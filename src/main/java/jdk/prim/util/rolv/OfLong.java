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

public class OfLong implements PrimitiveList.OfLong {

    private static class Rand extends jdk.prim.util.rolv.OfLong implements RandomAccess {

        public Rand(PrimitiveList.OfLong list, boolean modifiable) {
            super(list, modifiable);
        }
    }

    class DIterator implements PrimitiveIterator.OfLong {
        final PrimitiveListIterator.OfLong it = imp.listIteratorLong(imp.size());
        public boolean hasNext() { return it.hasPrevious(); }
        public long nextLong() { return it.previousLong(); }
        public void remove() {
            assessModability();
            it.remove();
        }
    }

    class DLIterator implements PrimitiveListIterator.OfLong {
        
        final PrimitiveListIterator.OfLong it;

        DLIterator(int size, int pos) {
            if (pos < 0 || pos > size)
                throw new IndexOutOfBoundsException();
            it = imp.listIteratorLong(size - pos);
        }

        public boolean hasNext() {
            return it.hasPrevious();
        }

        public long nextLong() {
            return it.previousLong();
        }

        public boolean hasPrevious() {
            return it.hasNext();
        }

        public long previousLong() {
            return it.nextLong();
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

        public void setLong(long e) {
            assessModability();
            it.setLong(e);
        }

        public void addLong(long e) {
            assessModability();
            it.addLong(e);
            it.previousLong();
        }
    
    }

    public static PrimitiveList.OfLong of(PrimitiveList.OfLong list, boolean modifiable) {
        if (list instanceof jdk.prim.util.rolv.OfLong rolv) {
            return rolv.imp;
        } else if (list instanceof RandomAccess) {
            return new jdk.prim.util.rolv.OfLong.Rand(list, modifiable);
        } else {
            return new jdk.prim.util.rolv.OfLong(list, modifiable);
        }
    }

    //implementation
    private PrimitiveList.OfLong imp;
    private boolean isMod;

    public OfLong(PrimitiveList.OfLong list, boolean modifiable) {
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
    public void forEach(jdk.prim.util.function.PrimitiveConsumer.OfLong action) {
        var it = iteratorLong();
        while(it.hasNext()) {
            action.acceptLong(it.nextLong());
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
    public boolean addAll(Collection<? extends java.lang.Long> c) {
        assessModability();
        if(c.size() == 0) return false;
        var it = c.iterator();
        while(it.hasNext()) imp.add(0, it.next());
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends java.lang.Long> c) {
        assessModability();
        int size = imp.size();
        checkClosedRange(index, size);
        var adds = (java.lang.Long[]) c.toArray();
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
        var it = iteratorLong();
        while (it.hasNext()) {
            if (c.contains(it.nextLong())) {
                it.remove();
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public void replaceAllLong(jdk.prim.util.function.PrimitiveFunction.ToLong.OfLong fn) {
        imp.replaceAllLong(fn);
    }

    @Override
    public boolean removeIfLong(jdk.prim.util.function.PrimitivePredicate.OfLong filter) {
        assessModability();
        return imp.removeIfLong(filter);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        assessModability();
        boolean modified = false;
        var it = iteratorLong();
        while (it.hasNext()) {
            if (!c.contains(it.nextLong())) {
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
    public boolean addLong(long element) {
        assessModability();
        return imp.addLong(element);
    }

    @Override
    public boolean addAllLong(jdk.prim.util.PrimitiveCollection.OfLong c) {
        assessModability();
        if(c.size() == 0) return false;
        var it = c.iteratorLong();
        while(it.hasNext()) imp.addLong(0, it.nextLong());
        return true;
    }

    @Override
    public boolean containsLong(long element) {
        return imp.containsLong(element);
    }

    @Override
    public boolean containsAllLong(jdk.prim.util.PrimitiveCollection.OfLong c) {
        return imp.containsAllLong(c);
    }

    @Override
    public jdk.prim.util.stream.PrimitiveStream.OfLong parallelStreamLong() {
        // TODO Will be implemented when primitive streams and splitterator are implemented
        throw new UnsupportedOperationException("Unimplemented method 'parallelStreamLong'");
    }

    @Override
    public boolean removeAllLong(jdk.prim.util.PrimitiveCollection.OfLong c) {
        assessModability();
        boolean modified = false;
        var it = iteratorLong();
        while (it.hasNext()) {
            if (c.containsLong(it.nextLong())) {
                it.remove();
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean retainAllLong(jdk.prim.util.PrimitiveCollection.OfLong c) {
        assessModability();
        boolean modified = false;
        var it = iteratorLong();
        while (it.hasNext()) {
            if (!c.containsLong(it.nextLong())) {
                it.remove();
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public jdk.prim.util.stream.PrimitiveStream.OfLong streamLong() {
        // TODO Will be implemented when primitive streams and splitterator are implemented
        throw new UnsupportedOperationException("Unimplemented method 'streamLong'");
    }

    @Override
    public long[] toArrayLong() {
        return PrimitiveArrays.reverse(imp.toArrayLong());
    }

    @Override
    public jdk.prim.util.PrimitiveIterator.OfLong iteratorLong() {
        return new DIterator();
    }

    @Override
    public void addLong(int index, long e) {
        assessModability();
        int l = imp.size();
        checkClosedRange(index, l);
        imp.addLong(l - index, e);
    }

    @Override
    public long getLong(int index) {
        int size = imp.size();
        Objects.checkIndex(index, size);
        return imp.getLong(size - index - 1);
    }

    @Override
    public int indexOfLong(long e) {
        int i = imp.lastIndexOfLong(e);
        return i == -1 ? -1 : imp.size() - i - 1;
    }

    @Override
    public int lastIndexOfLong(long e) {
        int i = imp.indexOfLong(e);
        return i == -1 ? -1 : imp.size() - i - 1;
    }

    @Override
    public jdk.prim.util.PrimitiveListIterator.OfLong listIteratorLong() {
        return new DLIterator(size(), 0);
    }

    @Override
    public jdk.prim.util.PrimitiveListIterator.OfLong listIteratorLong(int from) {
        int size = size();
        checkClosedRange(from, size);
        return new DLIterator(size, from);
    }

    @Override
    public long removeElementAtIndex(int i) {
        assessModability();
        int size = imp.size();
        Objects.checkIndex(i, size);
        return imp.removeElementAtIndex(size - i - 1);
    }

    @Override
    public boolean removeLong(long e) {
        assessModability();
        var it = iteratorLong();
        while (it.hasNext()) {
            if (e == it.nextLong()) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public long setLong(int index, long e) {
        assessModability();
        int size = imp.size();
        Objects.checkIndex(index, size);
        return imp.setLong(size - index - 1, e);
    }

    @Override
    public jdk.prim.util.PrimitiveList.OfLong subListLong(int from, int to) {
        int size = imp.size();
        Objects.checkFromToIndex(from, to, size);
        return new jdk.prim.util.rolv.OfLong(imp.subListLong(size - to, size - from), isMod);
    }

    @Override
    public java.lang.Long[] toArray() {
        return PrimitiveArrays.reverse(imp.toArray());
    }

    @Override
    public boolean addAllLong(int index, jdk.prim.util.PrimitiveCollection.OfLong e) {
        assessModability();
        int size = imp.size();
        checkClosedRange(index, size);
        var it = iteratorLong();
        if(!it.hasNext()) return false;
        while(it.hasNext()) imp.addLong(size - index, it.nextLong());
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof List))
            return false;

        var e1 = listIteratorLong();
        var e2 = ((List<?>) obj).listIterator();
        while (e1.hasNext() && e2.hasNext()) {
            long o1 = e1.nextLong();
            Object o2 = e2.next();
            if (!o2.equals(o1))
                return false;
        }
        return !(e1.hasNext() || e2.hasNext());
    }

    @Override
    public int hashCode() {
        int hashCode = 1;
        var it = iteratorLong();
        while(it.hasNext()) hashCode = 31 * hashCode + java.lang.Long.hashCode(it.nextLong());
        return hashCode;
    }

    @Override
    public String toString() {
        var it = iteratorLong();
        if (!it.hasNext())
            return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (;;) {
            long e = it.nextLong();
            sb.append(e);
            if (!it.hasNext())
                return sb.append(']').toString();
            sb.append(',').append(' ');
        }
    }

    @Override
    public long[] toArrayLong(long[] array) {
        var rev = toArrayLong();
        if(array.length < rev.length) return rev;
        System.arraycopy(rev, 0, array, 0, rev.length);
        return array;
    }

    @Override
    public long[] toArrayLong(jdk.prim.util.function.PrimitiveFunction.OfInt<long[]> generator) {
        return PrimitiveArrays.reverse(imp.toArrayLong(generator));
    }

    @Override
    public void sortLong(jdk.prim.util.PrimitiveComparator.OfLong c) {
        assessModability();
        jdk.prim.util.PrimitiveList.OfLong.super.sortLong(c.reversedLong());
    }
    
}
