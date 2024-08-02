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

public class OfShort implements PrimitiveList.OfShort {

    private static class Rand extends jdk.prim.util.rolv.OfShort implements RandomAccess {

        public Rand(PrimitiveList.OfShort list, boolean modifiable) {
            super(list, modifiable);
        }
    }

    class DIterator implements PrimitiveIterator.OfShort {
        final PrimitiveListIterator.OfShort it = imp.listIteratorShort(imp.size());
        public boolean hasNext() { return it.hasPrevious(); }
        public short nextShort() { return it.previousShort(); }
        public void remove() {
            assessModability();
            it.remove();
        }
    }

    class DLIterator implements PrimitiveListIterator.OfShort {
        
        final PrimitiveListIterator.OfShort it;

        DLIterator(int size, int pos) {
            if (pos < 0 || pos > size)
                throw new IndexOutOfBoundsException();
            it = imp.listIteratorShort(size - pos);
        }

        public boolean hasNext() {
            return it.hasPrevious();
        }

        public short nextShort() {
            return it.previousShort();
        }

        public boolean hasPrevious() {
            return it.hasNext();
        }

        public short previousShort() {
            return it.nextShort();
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

        public void setShort(short e) {
            assessModability();
            it.setShort(e);
        }

        public void addShort(short e) {
            assessModability();
            it.addShort(e);
            it.previousShort();
        }
    
    }

    public static PrimitiveList.OfShort of(PrimitiveList.OfShort list, boolean modifiable) {
        if (list instanceof jdk.prim.util.rolv.OfShort rolv) {
            return rolv.imp;
        } else if (list instanceof RandomAccess) {
            return new jdk.prim.util.rolv.OfShort.Rand(list, modifiable);
        } else {
            return new jdk.prim.util.rolv.OfShort(list, modifiable);
        }
    }

    //implementation
    private PrimitiveList.OfShort imp;
    private boolean isMod;

    public OfShort(PrimitiveList.OfShort list, boolean modifiable) {
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
    public void forEach(jdk.prim.util.function.PrimitiveConsumer.OfShort action) {
        var it = iteratorShort();
        while(it.hasNext()) {
            action.acceptShort(it.nextShort());
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
    public boolean addAll(Collection<? extends java.lang.Short> c) {
        assessModability();
        if(c.size() == 0) return false;
        var it = c.iterator();
        while(it.hasNext()) imp.add(0, it.next());
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends java.lang.Short> c) {
        assessModability();
        int size = imp.size();
        checkClosedRange(index, size);
        var adds = (java.lang.Short[]) c.toArray();
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
        var it = iteratorShort();
        while (it.hasNext()) {
            if (c.contains(it.nextShort())) {
                it.remove();
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public void replaceAllShort(jdk.prim.util.function.PrimitiveFunction.ToShort.OfShort fn) {
        imp.replaceAllShort(fn);
    }

    @Override
    public boolean removeIfShort(jdk.prim.util.function.PrimitivePredicate.OfShort filter) {
        assessModability();
        return imp.removeIfShort(filter);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        assessModability();
        boolean modified = false;
        var it = iteratorShort();
        while (it.hasNext()) {
            if (!c.contains(it.nextShort())) {
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
    public boolean addShort(short element) {
        assessModability();
        return imp.addShort(element);
    }

    @Override
    public boolean addAllShort(jdk.prim.util.PrimitiveCollection.OfShort c) {
        assessModability();
        if(c.size() == 0) return false;
        var it = c.iteratorShort();
        while(it.hasNext()) imp.addShort(0, it.nextShort());
        return true;
    }

    @Override
    public boolean containsShort(short element) {
        return imp.containsShort(element);
    }

    @Override
    public boolean containsAllShort(jdk.prim.util.PrimitiveCollection.OfShort c) {
        return imp.containsAllShort(c);
    }

    @Override
    public jdk.prim.util.stream.PrimitiveStream.OfShort parallelStreamShort() {
        // TODO Will be implemented when primitive streams and splitterator are implemented
        throw new UnsupportedOperationException("Unimplemented method 'parallelStreamShort'");
    }

    @Override
    public boolean removeAllShort(jdk.prim.util.PrimitiveCollection.OfShort c) {
        assessModability();
        boolean modified = false;
        var it = iteratorShort();
        while (it.hasNext()) {
            if (c.containsShort(it.nextShort())) {
                it.remove();
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean retainAllShort(jdk.prim.util.PrimitiveCollection.OfShort c) {
        assessModability();
        boolean modified = false;
        var it = iteratorShort();
        while (it.hasNext()) {
            if (!c.containsShort(it.nextShort())) {
                it.remove();
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public jdk.prim.util.stream.PrimitiveStream.OfShort streamShort() {
        // TODO Will be implemented when primitive streams and splitterator are implemented
        throw new UnsupportedOperationException("Unimplemented method 'streamShort'");
    }

    @Override
    public short[] toArrayShort() {
        return PrimitiveArrays.reverse(imp.toArrayShort());
    }

    @Override
    public jdk.prim.util.PrimitiveIterator.OfShort iteratorShort() {
        return new DIterator();
    }

    @Override
    public void addShort(int index, short e) {
        assessModability();
        int l = imp.size();
        checkClosedRange(index, l);
        imp.addShort(l - index, e);
    }

    @Override
    public short getShort(int index) {
        int size = imp.size();
        Objects.checkIndex(index, size);
        return imp.getShort(size - index - 1);
    }

    @Override
    public int indexOfShort(short e) {
        int i = imp.lastIndexOfShort(e);
        return i == -1 ? -1 : imp.size() - i - 1;
    }

    @Override
    public int lastIndexOfShort(short e) {
        int i = imp.indexOfShort(e);
        return i == -1 ? -1 : imp.size() - i - 1;
    }

    @Override
    public jdk.prim.util.PrimitiveListIterator.OfShort listIteratorShort() {
        return new DLIterator(size(), 0);
    }

    @Override
    public jdk.prim.util.PrimitiveListIterator.OfShort listIteratorShort(int from) {
        int size = size();
        checkClosedRange(from, size);
        return new DLIterator(size, from);
    }

    @Override
    public short removeElementAtIndex(int i) {
        assessModability();
        int size = imp.size();
        Objects.checkIndex(i, size);
        return imp.removeElementAtIndex(size - i - 1);
    }

    @Override
    public boolean removeShort(short e) {
        assessModability();
        var it = iteratorShort();
        while (it.hasNext()) {
            if (e == it.nextShort()) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public short setShort(int index, short e) {
        assessModability();
        int size = imp.size();
        Objects.checkIndex(index, size);
        return imp.setShort(size - index - 1, e);
    }

    @Override
    public jdk.prim.util.PrimitiveList.OfShort subListShort(int from, int to) {
        int size = imp.size();
        Objects.checkFromToIndex(from, to, size);
        return new jdk.prim.util.rolv.OfShort(imp.subListShort(size - to, size - from), isMod);
    }

    @Override
    public java.lang.Short[] toArray() {
        return PrimitiveArrays.reverse(imp.toArray());
    }

    @Override
    public boolean addAllShort(int index, jdk.prim.util.PrimitiveCollection.OfShort e) {
        assessModability();
        int size = imp.size();
        checkClosedRange(index, size);
        var it = iteratorShort();
        if(!it.hasNext()) return false;
        while(it.hasNext()) imp.addShort(size - index, it.nextShort());
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof List))
            return false;

        var e1 = listIteratorShort();
        var e2 = ((List<?>) obj).listIterator();
        while (e1.hasNext() && e2.hasNext()) {
            short o1 = e1.nextShort();
            Object o2 = e2.next();
            if (!o2.equals(o1))
                return false;
        }
        return !(e1.hasNext() || e2.hasNext());
    }

    @Override
    public int hashCode() {
        int hashCode = 1;
        var it = iteratorShort();
        while(it.hasNext()) hashCode = 31 * hashCode + java.lang.Short.hashCode(it.nextShort());
        return hashCode;
    }

    @Override
    public String toString() {
        var it = iteratorShort();
        if (!it.hasNext())
            return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (;;) {
            short e = it.nextShort();
            sb.append(e);
            if (!it.hasNext())
                return sb.append(']').toString();
            sb.append(',').append(' ');
        }
    }

    @Override
    public short[] toArrayShort(short[] array) {
        var rev = toArrayShort();
        if(array.length < rev.length) return rev;
        System.arraycopy(rev, 0, array, 0, rev.length);
        return array;
    }

    @Override
    public short[] toArrayShort(jdk.prim.util.function.PrimitiveFunction.OfInt<short[]> generator) {
        return PrimitiveArrays.reverse(imp.toArrayShort(generator));
    }

    @Override
    public void sortShort(jdk.prim.util.PrimitiveComparator.OfShort c) {
        assessModability();
        jdk.prim.util.PrimitiveList.OfShort.super.sortShort(c.reversedShort());
    }
    
}
