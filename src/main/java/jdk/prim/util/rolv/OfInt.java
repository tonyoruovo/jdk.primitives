package jdk.prim.util.rolv;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.function.IntFunction;

import jdk.prim.util.PrimitiveArrays;
import jdk.prim.util.PrimitiveIterator;
import jdk.prim.util.PrimitiveList;
import jdk.prim.util.PrimitiveListIterator;

public class OfInt implements PrimitiveList.OfInt {

    private static class Rand extends jdk.prim.util.rolv.OfInt implements RandomAccess {

        public Rand(PrimitiveList.OfInt list, boolean modifiable) {
            super(list, modifiable);
        }
    }

    class DIterator implements PrimitiveIterator.OfInt {
        final PrimitiveListIterator.OfInt it = imp.listIteratorInt(imp.size());
        public boolean hasNext() { return it.hasPrevious(); }
        public int nextInt() { return it.previousInt(); }
        public void remove() {
            assessModability();
            it.remove();
        }
    }

    class DLIterator implements PrimitiveListIterator.OfInt {
        
        final PrimitiveListIterator.OfInt it;

        DLIterator(int size, int pos) {
            if (pos < 0 || pos > size)
                throw new IndexOutOfBoundsException();
            it = imp.listIteratorInt(size - pos);
        }

        public boolean hasNext() {
            return it.hasPrevious();
        }

        public int nextInt() {
            return it.previousInt();
        }

        public boolean hasPrevious() {
            return it.hasNext();
        }

        public int previousInt() {
            return it.nextInt();
        }

        public int nextIndex() {
            return imp.size() - it.nextIndex();
        }

        public int previousIndex() {
            return nextIndex() - 1;
        }

        public void remove() {
            assessModability();
            it.remove();
        }

        public void setInt(int e) {
            assessModability();
            it.setInt(e);
        }

        public void addInt(int e) {
            assessModability();
            it.addInt(e);
            it.previousInt();
        }
    
    }

    public static PrimitiveList.OfInt of(PrimitiveList.OfInt list, boolean modifiable) {
        if (list instanceof jdk.prim.util.rolv.OfInt rolv) {
            return rolv.imp;
        } else if (list instanceof RandomAccess) {
            return new jdk.prim.util.rolv.OfInt.Rand(list, modifiable);
        } else {
            return new jdk.prim.util.rolv.OfInt(list, modifiable);
        }
    }

    //implementation
    private PrimitiveList.OfInt imp;
    private boolean isMod;

    public OfInt(PrimitiveList.OfInt list, boolean modifiable) {
        super();
        imp = list;
        isMod = modifiable;
    }

    private void assessModability() {
        if(isMod) throw new UnsupportedOperationException();
    }

    private void checkClosedRange(int index, int size) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    @Override
    public void forEach(jdk.prim.util.function.PrimitiveConsumer.OfInt action) {
        var it = iteratorInt();
        while(it.hasNext()) {
            action.acceptInt(it.nextInt());
        }
    }

    @Override
    public int size() {
        return imp.size();
    }

    @Override
    public boolean isEmpty() {
        return imp.isEmpty();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        T[] rev = PrimitiveArrays.reverse(imp.toArray(Arrays.copyOfRange(a, 0, 0)));
        if (rev.length > a.length) {
            return rev;
        } else {
            System.arraycopy(rev, 0, a, 0, rev.length);
            if (a.length > rev.length) {
                a[rev.length] = null;
            }
            return a;
        }
    }

    @Override
    public <T> T[] toArray(IntFunction<T[]> generator) {
        return PrimitiveArrays.reverse(imp.toArray(generator));
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return imp.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends java.lang.Integer> c) {
        assessModability();
        if(c.size() == 0) return false;
        var it = c.iterator();
        while(it.hasNext()) imp.add(0, it.next());
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends java.lang.Integer> c) {
        assessModability();
        int size = imp.size();
        checkClosedRange(index, size);
        var adds = (java.lang.Integer[]) c.toArray();
        if (adds.length == 0) {
            return false;
        } else {
            imp.addAll(size - index, Arrays.asList(PrimitiveArrays.reverse(adds)));
            return true;
        }
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        assessModability();
        boolean modified = false;
        var it = iteratorInt();
        while (it.hasNext()) {
            if (c.contains(it.nextInt())) {
                it.remove();
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public void replaceAllInt(jdk.prim.util.function.PrimitiveFunction.ToInt.OfInt fn) {
        imp.replaceAllInt(fn);
    }

    @Override
    public boolean removeIfInt(jdk.prim.util.function.PrimitivePredicate.OfInt filter) {
        assessModability();
        return imp.removeIfInt(filter);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        assessModability();
        boolean modified = false;
        var it = iteratorInt();
        while (it.hasNext()) {
            if (!c.contains(it.nextInt())) {
                it.remove();
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public void clear() {
        assessModability();
        imp.clear();
    }

    @Override
    public boolean addInt(int element) {
        assessModability();
        return imp.addInt(element);
    }

    @Override
    public boolean addAllInt(jdk.prim.util.PrimitiveCollection.OfInt c) {
        assessModability();
        if(c.size() == 0) return false;
        var it = c.iteratorInt();
        while(it.hasNext()) imp.addInt(0, it.nextInt());
        return true;
    }

    @Override
    public boolean containsInt(int element) {
        return imp.containsInt(element);
    }

    @Override
    public boolean containsAllInt(jdk.prim.util.PrimitiveCollection.OfInt c) {
        return imp.containsAllInt(c);
    }

    @Override
    public jdk.prim.util.stream.PrimitiveStream.OfInt parallelStreamInt() {
        // TODO Will be implemented when primitive streams and splitterator are implemented
        throw new UnsupportedOperationException("Unimplemented method 'parallelStreamInt'");
    }

    @Override
    public boolean removeAllInt(jdk.prim.util.PrimitiveCollection.OfInt c) {
        assessModability();
        boolean modified = false;
        var it = iteratorInt();
        while (it.hasNext()) {
            if (c.containsInt(it.nextInt())) {
                it.remove();
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean retainAllInt(jdk.prim.util.PrimitiveCollection.OfInt c) {
        assessModability();
        boolean modified = false;
        var it = iteratorInt();
        while (it.hasNext()) {
            if (!c.containsInt(it.nextInt())) {
                it.remove();
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public jdk.prim.util.stream.PrimitiveStream.OfInt streamInt() {
        // TODO Will be implemented when primitive streams and splitterator are implemented
        throw new UnsupportedOperationException("Unimplemented method 'streamInt'");
    }

    @Override
    public int[] toArrayInt() {
        return PrimitiveArrays.reverse(imp.toArrayInt());
    }

    @Override
    public jdk.prim.util.PrimitiveIterator.OfInt iteratorInt() {
        return new DIterator();
    }

    @Override
    public void addInt(int index, int e) {
        assessModability();
        int l = imp.size();
        checkClosedRange(index, l);
        imp.addInt(l - index, e);
    }

    @Override
    public int getInt(int index) {
        int size = imp.size();
        Objects.checkIndex(index, size);
        return imp.getInt(size - index - 1);
    }

    @Override
    public int indexOfInt(int e) {
        int i = imp.lastIndexOfInt(e);
        return i == -1 ? -1 : imp.size() - i - 1;
    }

    @Override
    public int lastIndexOfInt(int e) {
        int i = imp.indexOfInt(e);
        return i == -1 ? -1 : imp.size() - i - 1;
    }

    @Override
    public jdk.prim.util.PrimitiveListIterator.OfInt listIteratorInt() {
        return new DLIterator(size(), 0);
    }

    @Override
    public jdk.prim.util.PrimitiveListIterator.OfInt listIteratorInt(int from) {
        int size = size();
        checkClosedRange(from, size);
        return new DLIterator(size, from);
    }

    @Override
    public int removeElementAtIndex(int i) {
        assessModability();
        int size = imp.size();
        Objects.checkIndex(i, size);
        return imp.removeElementAtIndex(size - i - 1);
    }

    @Override
    public boolean removeInt(int e) {
        assessModability();
        var it = iteratorInt();
        while (it.hasNext()) {
            if (e == it.nextInt()) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public int setInt(int index, int e) {
        assessModability();
        int size = imp.size();
        Objects.checkIndex(index, size);
        return imp.setInt(size - index - 1, e);
    }

    @Override
    public jdk.prim.util.PrimitiveList.OfInt subListInt(int from, int to) {
        int size = imp.size();
        Objects.checkFromToIndex(from, to, size);
        return new jdk.prim.util.rolv.OfInt(imp.subListInt(size - to, size - from), isMod);
    }

    @Override
    public java.lang.Integer[] toArray() {
        return PrimitiveArrays.reverse(imp.toArray());
    }

    @Override
    public boolean addAllInt(int index, jdk.prim.util.PrimitiveCollection.OfInt e) {
        assessModability();
        int size = imp.size();
        checkClosedRange(index, size);
        var it = iteratorInt();
        if(!it.hasNext()) return false;
        while(it.hasNext()) imp.addInt(size - index, it.nextInt());
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof List))
            return false;

        var e1 = listIteratorInt();
        var e2 = ((List<?>) obj).listIterator();
        while (e1.hasNext() && e2.hasNext()) {
            int o1 = e1.nextInt();
            Object o2 = e2.next();
            if (!o2.equals(o1))
                return false;
        }
        return !(e1.hasNext() || e2.hasNext());
    }

    @Override
    public int hashCode() {
        int hashCode = 1;
        var it = iteratorInt();
        while(it.hasNext()) hashCode = 31 * hashCode + java.lang.Integer.hashCode(it.nextInt());
        return hashCode;
    }

    @Override
    public String toString() {
        var it = iteratorInt();
        if (!it.hasNext())
            return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (;;) {
            int e = it.nextInt();
            sb.append(e);
            if (!it.hasNext())
                return sb.append(']').toString();
            sb.append(',').append(' ');
        }
    }

    @Override
    public int[] toArrayInt(int[] array) {
        var rev = toArrayInt();
        if(array.length < rev.length) return rev;
        System.arraycopy(rev, 0, array, 0, rev.length);
        return array;
    }

    @Override
    public int[] toArrayInt(jdk.prim.util.function.PrimitiveFunction.OfInt<int[]> generator) {
        return PrimitiveArrays.reverse(imp.toArrayInt(generator));
    }

    @Override
    public void sortInt(jdk.prim.util.PrimitiveComparator.OfInt c) {
        assessModability();
        jdk.prim.util.PrimitiveList.OfInt.super.sortInt(c.reversedInt());
    }
    
}
