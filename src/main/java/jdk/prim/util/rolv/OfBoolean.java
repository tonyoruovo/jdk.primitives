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

public class OfBoolean implements PrimitiveList.OfBoolean {

    private static class Rand extends jdk.prim.util.rolv.OfBoolean implements RandomAccess {

        public Rand(PrimitiveList.OfBoolean list, boolean modifiable) {
            super(list, modifiable);
        }
    }

    class DIterator implements PrimitiveIterator.OfBoolean {
        final PrimitiveListIterator.OfBoolean it = imp.listIteratorBoolean(imp.size());
        public boolean hasNext() { return it.hasPrevious(); }
        public boolean nextBoolean() { return it.previousBoolean(); }
        public void remove() {
            assessModability();
            it.remove();
        }
    }

    class DLIterator implements PrimitiveListIterator.OfBoolean {
        
        final PrimitiveListIterator.OfBoolean it;

        DLIterator(int size, int pos) {
            if (pos < 0 || pos > size)
                throw new IndexOutOfBoundsException();
            it = imp.listIteratorBoolean(size - pos);
        }

        public boolean hasNext() {
            return it.hasPrevious();
        }

        public boolean nextBoolean() {
            return it.previousBoolean();
        }

        public boolean hasPrevious() {
            return it.hasNext();
        }

        public boolean previousBoolean() {
            return it.nextBoolean();
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

        public void setBoolean(boolean e) {
            assessModability();
            it.setBoolean(e);
        }

        public void addBoolean(boolean e) {
            assessModability();
            it.addBoolean(e);
            it.previousBoolean();
        }
    
    }

    public static PrimitiveList.OfBoolean of(PrimitiveList.OfBoolean list, boolean modifiable) {
        if (list instanceof jdk.prim.util.rolv.OfBoolean rolv) {
            return rolv.imp;
        } else if (list instanceof RandomAccess) {
            return new jdk.prim.util.rolv.OfBoolean.Rand(list, modifiable);
        } else {
            return new jdk.prim.util.rolv.OfBoolean(list, modifiable);
        }
    }

    //implementation
    private PrimitiveList.OfBoolean imp;
    private boolean isMod;

    public OfBoolean(PrimitiveList.OfBoolean list, boolean modifiable) {
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
    public void forEach(jdk.prim.util.function.PrimitiveConsumer.OfBoolean action) {
        var it = iteratorBoolean();
        while(it.hasNext()) {
            action.acceptBoolean(it.nextBoolean());
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
    public boolean addAll(Collection<? extends java.lang.Boolean> c) {
        assessModability();
        if(c.size() == 0) return false;
        var it = c.iterator();
        while(it.hasNext()) imp.add(0, it.next());
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends java.lang.Boolean> c) {
        assessModability();
        int size = imp.size();
        checkClosedRange(index, size);
        var adds = (java.lang.Boolean[]) c.toArray();
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
        var it = iteratorBoolean();
        while (it.hasNext()) {
            if (c.contains(it.nextBoolean())) {
                it.remove();
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public void replaceAllBoolean(jdk.prim.util.function.PrimitiveFunction.ToBoolean.OfBoolean fn) {
        imp.replaceAllBoolean(fn);
    }

    @Override
    public boolean removeIfBoolean(jdk.prim.util.function.PrimitivePredicate.OfBoolean filter) {
        assessModability();
        return imp.removeIfBoolean(filter);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        assessModability();
        boolean modified = false;
        var it = iteratorBoolean();
        while (it.hasNext()) {
            if (!c.contains(it.nextBoolean())) {
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
    public boolean addBoolean(boolean element) {
        assessModability();
        return imp.addBoolean(element);
    }

    @Override
    public boolean addAllBoolean(jdk.prim.util.PrimitiveCollection.OfBoolean c) {
        assessModability();
        if(c.size() == 0) return false;
        var it = c.iteratorBoolean();
        while(it.hasNext()) imp.addBoolean(0, it.nextBoolean());
        return true;
    }

    @Override
    public boolean containsBoolean(boolean element) {
        return imp.containsBoolean(element);
    }

    @Override
    public boolean containsAllBoolean(jdk.prim.util.PrimitiveCollection.OfBoolean c) {
        return imp.containsAllBoolean(c);
    }

    @Override
    public jdk.prim.util.stream.PrimitiveStream.OfBoolean parallelStreamBoolean() {
        // TODO Will be implemented when primitive streams and splitterator are implemented
        throw new UnsupportedOperationException("Unimplemented method 'parallelStreamBoolean'");
    }

    @Override
    public boolean removeAllBoolean(jdk.prim.util.PrimitiveCollection.OfBoolean c) {
        assessModability();
        boolean modified = false;
        var it = iteratorBoolean();
        while (it.hasNext()) {
            if (c.containsBoolean(it.nextBoolean())) {
                it.remove();
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean retainAllBoolean(jdk.prim.util.PrimitiveCollection.OfBoolean c) {
        assessModability();
        boolean modified = false;
        var it = iteratorBoolean();
        while (it.hasNext()) {
            if (!c.containsBoolean(it.nextBoolean())) {
                it.remove();
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public jdk.prim.util.stream.PrimitiveStream.OfBoolean streamBoolean() {
        // TODO Will be implemented when primitive streams and splitterator are implemented
        throw new UnsupportedOperationException("Unimplemented method 'streamBoolean'");
    }

    @Override
    public boolean[] toArrayBoolean() {
        return PrimitiveArrays.reverse(imp.toArrayBoolean());
    }

    @Override
    public jdk.prim.util.PrimitiveIterator.OfBoolean iteratorBoolean() {
        return new DIterator();
    }

    @Override
    public void addBoolean(int index, boolean e) {
        assessModability();
        int l = imp.size();
        checkClosedRange(index, l);
        imp.addBoolean(l - index, e);
    }

    @Override
    public boolean getBoolean(int index) {
        int size = imp.size();
        Objects.checkIndex(index, size);
        return imp.getBoolean(size - index - 1);
    }

    @Override
    public int indexOfBoolean(boolean e) {
        int i = imp.lastIndexOfBoolean(e);
        return i == -1 ? -1 : imp.size() - i - 1;
    }

    @Override
    public int lastIndexOfBoolean(boolean e) {
        int i = imp.indexOfBoolean(e);
        return i == -1 ? -1 : imp.size() - i - 1;
    }

    @Override
    public jdk.prim.util.PrimitiveListIterator.OfBoolean listIteratorBoolean() {
        return new DLIterator(size(), 0);
    }

    @Override
    public jdk.prim.util.PrimitiveListIterator.OfBoolean listIteratorBoolean(int from) {
        int size = size();
        checkClosedRange(from, size);
        return new DLIterator(size, from);
    }

    @Override
    public boolean removeElementAtIndex(int i) {
        assessModability();
        int size = imp.size();
        Objects.checkIndex(i, size);
        return imp.removeElementAtIndex(size - i - 1);
    }

    @Override
    public boolean removeBoolean(boolean e) {
        assessModability();
        var it = iteratorBoolean();
        while (it.hasNext()) {
            if (e == it.nextBoolean()) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setBoolean(int index, boolean e) {
        assessModability();
        int size = imp.size();
        Objects.checkIndex(index, size);
        return imp.setBoolean(size - index - 1, e);
    }

    @Override
    public jdk.prim.util.PrimitiveList.OfBoolean subListBoolean(int from, int to) {
        int size = imp.size();
        Objects.checkFromToIndex(from, to, size);
        return new jdk.prim.util.rolv.OfBoolean(imp.subListBoolean(size - to, size - from), isMod);
    }

    @Override
    public java.lang.Boolean[] toArray() {
        return PrimitiveArrays.reverse(imp.toArray());
    }

    @Override
    public boolean addAllBoolean(int index, jdk.prim.util.PrimitiveCollection.OfBoolean e) {
        assessModability();
        int size = imp.size();
        checkClosedRange(index, size);
        var it = iteratorBoolean();
        if(!it.hasNext()) return false;
        while(it.hasNext()) imp.addBoolean(size - index, it.nextBoolean());
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof List))
            return false;

        var e1 = listIteratorBoolean();
        var e2 = ((List<?>) obj).listIterator();
        while (e1.hasNext() && e2.hasNext()) {
            boolean o1 = e1.nextBoolean();
            Object o2 = e2.next();
            if (!o2.equals(o1))
                return false;
        }
        return !(e1.hasNext() || e2.hasNext());
    }

    @Override
    public int hashCode() {
        int hashCode = 1;
        var it = iteratorBoolean();
        while(it.hasNext()) hashCode = 31 * hashCode + java.lang.Boolean.hashCode(it.nextBoolean());
        return hashCode;
    }

    @Override
    public String toString() {
        var it = iteratorBoolean();
        if (!it.hasNext())
            return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (;;) {
            boolean e = it.nextBoolean();
            sb.append(e);
            if (!it.hasNext())
                return sb.append(']').toString();
            sb.append(',').append(' ');
        }
    }

    @Override
    public boolean[] toArrayBoolean(boolean[] array) {
        var rev = toArrayBoolean();
        if(array.length < rev.length) return rev;
        System.arraycopy(rev, 0, array, 0, rev.length);
        return array;
    }

    @Override
    public boolean[] toArrayBoolean(jdk.prim.util.function.PrimitiveFunction.OfInt<boolean[]> generator) {
        return PrimitiveArrays.reverse(imp.toArrayBoolean(generator));
    }

    @Override
    public void sortBoolean(jdk.prim.util.PrimitiveComparator.OfBoolean c) {
        assessModability();
        jdk.prim.util.PrimitiveList.OfBoolean.super.sortBoolean(c.reversedBoolean());
    }
    
}
