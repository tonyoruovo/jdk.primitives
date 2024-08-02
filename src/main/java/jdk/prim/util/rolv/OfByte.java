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

public class OfByte implements PrimitiveList.OfByte {

    private static class Rand extends jdk.prim.util.rolv.OfByte implements RandomAccess {

        public Rand(PrimitiveList.OfByte list, boolean modifiable) {
            super(list, modifiable);
        }
    }

    class DIterator implements PrimitiveIterator.OfByte {
        final PrimitiveListIterator.OfByte it = imp.listIteratorByte(imp.size());
        public boolean hasNext() { return it.hasPrevious(); }
        public byte nextByte() { return it.previousByte(); }
        public void remove() {
            assessModability();
            it.remove();
        }
    }

    class DLIterator implements PrimitiveListIterator.OfByte {
        
        final PrimitiveListIterator.OfByte it;

        DLIterator(int size, int pos) {
            if (pos < 0 || pos > size)
                throw new IndexOutOfBoundsException();
            it = imp.listIteratorByte(size - pos);
        }

        public boolean hasNext() {
            return it.hasPrevious();
        }

        public byte nextByte() {
            return it.previousByte();
        }

        public boolean hasPrevious() {
            return it.hasNext();
        }

        public byte previousByte() {
            return it.nextByte();
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

        public void setByte(byte e) {
            assessModability();
            it.setByte(e);
        }

        public void addByte(byte e) {
            assessModability();
            it.addByte(e);
            it.previousByte();
        }
    
    }

    public static PrimitiveList.OfByte of(PrimitiveList.OfByte list, boolean modifiable) {
        if (list instanceof jdk.prim.util.rolv.OfByte rolv) {
            return rolv.imp;
        } else if (list instanceof RandomAccess) {
            return new jdk.prim.util.rolv.OfByte.Rand(list, modifiable);
        } else {
            return new jdk.prim.util.rolv.OfByte(list, modifiable);
        }
    }

    //implementation
    private PrimitiveList.OfByte imp;
    private boolean isMod;

    public OfByte(PrimitiveList.OfByte list, boolean modifiable) {
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
    public void forEach(jdk.prim.util.function.PrimitiveConsumer.OfByte action) {
        var it = iteratorByte();
        while(it.hasNext()) {
            action.acceptByte(it.nextByte());
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
    public boolean addAll(Collection<? extends java.lang.Byte> c) {
        assessModability();
        if(c.size() == 0) return false;
        var it = c.iterator();
        while(it.hasNext()) imp.add(0, it.next());
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends java.lang.Byte> c) {
        assessModability();
        int size = imp.size();
        checkClosedRange(index, size);
        var adds = (java.lang.Byte[]) c.toArray();
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
        var it = iteratorByte();
        while (it.hasNext()) {
            if (c.contains(it.nextByte())) {
                it.remove();
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public void replaceAllByte(jdk.prim.util.function.PrimitiveFunction.ToByte.OfByte fn) {
        imp.replaceAllByte(fn);
    }

    @Override
    public boolean removeIfByte(jdk.prim.util.function.PrimitivePredicate.OfByte filter) {
        assessModability();
        return imp.removeIfByte(filter);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        assessModability();
        boolean modified = false;
        var it = iteratorByte();
        while (it.hasNext()) {
            if (!c.contains(it.nextByte())) {
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
    public boolean addByte(byte element) {
        assessModability();
        return imp.addByte(element);
    }

    @Override
    public boolean addAllByte(jdk.prim.util.PrimitiveCollection.OfByte c) {
        assessModability();
        if(c.size() == 0) return false;
        var it = c.iteratorByte();
        while(it.hasNext()) imp.addByte(0, it.nextByte());
        return true;
    }

    @Override
    public boolean containsByte(byte element) {
        return imp.containsByte(element);
    }

    @Override
    public boolean containsAllByte(jdk.prim.util.PrimitiveCollection.OfByte c) {
        return imp.containsAllByte(c);
    }

    @Override
    public jdk.prim.util.stream.PrimitiveStream.OfByte parallelStreamByte() {
        // TODO Will be implemented when primitive streams and splitterator are implemented
        throw new UnsupportedOperationException("Unimplemented method 'parallelStreamByte'");
    }

    @Override
    public boolean removeAllByte(jdk.prim.util.PrimitiveCollection.OfByte c) {
        assessModability();
        boolean modified = false;
        var it = iteratorByte();
        while (it.hasNext()) {
            if (c.containsByte(it.nextByte())) {
                it.remove();
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean retainAllByte(jdk.prim.util.PrimitiveCollection.OfByte c) {
        assessModability();
        boolean modified = false;
        var it = iteratorByte();
        while (it.hasNext()) {
            if (!c.containsByte(it.nextByte())) {
                it.remove();
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public jdk.prim.util.stream.PrimitiveStream.OfByte streamByte() {
        // TODO Will be implemented when primitive streams and splitterator are implemented
        throw new UnsupportedOperationException("Unimplemented method 'streamByte'");
    }

    @Override
    public byte[] toArrayByte() {
        return PrimitiveArrays.reverse(imp.toArrayByte());
    }

    @Override
    public jdk.prim.util.PrimitiveIterator.OfByte iteratorByte() {
        return new DIterator();
    }

    @Override
    public void addByte(int index, byte e) {
        assessModability();
        int l = imp.size();
        checkClosedRange(index, l);
        imp.addByte(l - index, e);
    }

    @Override
    public byte getByte(int index) {
        int size = imp.size();
        Objects.checkIndex(index, size);
        return imp.getByte(size - index - 1);
    }

    @Override
    public int indexOfByte(byte e) {
        int i = imp.lastIndexOfByte(e);
        return i == -1 ? -1 : imp.size() - i - 1;
    }

    @Override
    public int lastIndexOfByte(byte e) {
        int i = imp.indexOfByte(e);
        return i == -1 ? -1 : imp.size() - i - 1;
    }

    @Override
    public jdk.prim.util.PrimitiveListIterator.OfByte listIteratorByte() {
        return new DLIterator(size(), 0);
    }

    @Override
    public jdk.prim.util.PrimitiveListIterator.OfByte listIteratorByte(int from) {
        int size = size();
        checkClosedRange(from, size);
        return new DLIterator(size, from);
    }

    @Override
    public byte removeElementAtIndex(int i) {
        assessModability();
        int size = imp.size();
        Objects.checkIndex(i, size);
        return imp.removeElementAtIndex(size - i - 1);
    }

    @Override
    public boolean removeByte(byte e) {
        assessModability();
        var it = iteratorByte();
        while (it.hasNext()) {
            if (e == it.nextByte()) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public byte setByte(int index, byte e) {
        assessModability();
        int size = imp.size();
        Objects.checkIndex(index, size);
        return imp.setByte(size - index - 1, e);
    }

    @Override
    public jdk.prim.util.PrimitiveList.OfByte subListByte(int from, int to) {
        int size = imp.size();
        Objects.checkFromToIndex(from, to, size);
        return new jdk.prim.util.rolv.OfByte(imp.subListByte(size - to, size - from), isMod);
    }

    @Override
    public java.lang.Byte[] toArray() {
        return PrimitiveArrays.reverse(imp.toArray());
    }

    @Override
    public boolean addAllByte(int index, jdk.prim.util.PrimitiveCollection.OfByte e) {
        assessModability();
        int size = imp.size();
        checkClosedRange(index, size);
        var it = iteratorByte();
        if(!it.hasNext()) return false;
        while(it.hasNext()) imp.addByte(size - index, it.nextByte());
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof List))
            return false;

        var e1 = listIteratorByte();
        var e2 = ((List<?>) obj).listIterator();
        while (e1.hasNext() && e2.hasNext()) {
            byte o1 = e1.nextByte();
            Object o2 = e2.next();
            if (!o2.equals(o1))
                return false;
        }
        return !(e1.hasNext() || e2.hasNext());
    }

    @Override
    public int hashCode() {
        int hashCode = 1;
        var it = iteratorByte();
        while(it.hasNext()) hashCode = 31 * hashCode + java.lang.Byte.hashCode(it.nextByte());
        return hashCode;
    }

    @Override
    public String toString() {
        var it = iteratorByte();
        if (!it.hasNext())
            return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (;;) {
            byte e = it.nextByte();
            sb.append(e);
            if (!it.hasNext())
                return sb.append(']').toString();
            sb.append(',').append(' ');
        }
    }

    @Override
    public byte[] toArrayByte(byte[] array) {
        var rev = toArrayByte();
        if(array.length < rev.length) return rev;
        System.arraycopy(rev, 0, array, 0, rev.length);
        return array;
    }

    @Override
    public byte[] toArrayByte(jdk.prim.util.function.PrimitiveFunction.OfInt<byte[]> generator) {
        return PrimitiveArrays.reverse(imp.toArrayByte(generator));
    }

    @Override
    public void sortByte(jdk.prim.util.PrimitiveComparator.OfByte c) {
        assessModability();
        jdk.prim.util.PrimitiveList.OfByte.super.sortByte(c.reversedByte());
    }
    
}
