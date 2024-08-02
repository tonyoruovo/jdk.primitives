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

public class OfFloat implements PrimitiveList.OfFloat {

    private static class Rand extends jdk.prim.util.rolv.OfFloat implements RandomAccess {

        public Rand(PrimitiveList.OfFloat list, boolean modifiable) {
            super(list, modifiable);
        }
    }

    class DIterator implements PrimitiveIterator.OfFloat {
        final PrimitiveListIterator.OfFloat it = imp.listIteratorFloat(imp.size());
        public boolean hasNext() { return it.hasPrevious(); }
        public float nextFloat() { return it.previousFloat(); }
        public void remove() {
            assessModability();
            it.remove();
        }
    }

    class DLIterator implements PrimitiveListIterator.OfFloat {
        
        final PrimitiveListIterator.OfFloat it;

        DLIterator(int size, int pos) {
            if (pos < 0 || pos > size)
                throw new IndexOutOfBoundsException();
            it = imp.listIteratorFloat(size - pos);
        }

        public boolean hasNext() {
            return it.hasPrevious();
        }

        public float nextFloat() {
            return it.previousFloat();
        }

        public boolean hasPrevious() {
            return it.hasNext();
        }

        public float previousFloat() {
            return it.nextFloat();
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

        public void setFloat(float e) {
            assessModability();
            it.setFloat(e);
        }

        public void addFloat(float e) {
            assessModability();
            it.addFloat(e);
            it.previousFloat();
        }
    
    }

    public static PrimitiveList.OfFloat of(PrimitiveList.OfFloat list, boolean modifiable) {
        if (list instanceof jdk.prim.util.rolv.OfFloat rolv) {
            return rolv.imp;
        } else if (list instanceof RandomAccess) {
            return new jdk.prim.util.rolv.OfFloat.Rand(list, modifiable);
        } else {
            return new jdk.prim.util.rolv.OfFloat(list, modifiable);
        }
    }

    //implementation
    private PrimitiveList.OfFloat imp;
    private boolean isMod;

    public OfFloat(PrimitiveList.OfFloat list, boolean modifiable) {
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
    public void forEach(jdk.prim.util.function.PrimitiveConsumer.OfFloat action) {
        var it = iteratorFloat();
        while(it.hasNext()) {
            action.acceptFloat(it.nextFloat());
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
    public boolean addAll(Collection<? extends java.lang.Float> c) {
        assessModability();
        if(c.size() == 0) return false;
        var it = c.iterator();
        while(it.hasNext()) imp.add(0, it.next());
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends java.lang.Float> c) {
        assessModability();
        int size = imp.size();
        checkClosedRange(index, size);
        var adds = (java.lang.Float[]) c.toArray();
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
        var it = iteratorFloat();
        while (it.hasNext()) {
            if (c.contains(it.nextFloat())) {
                it.remove();
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public void replaceAllFloat(jdk.prim.util.function.PrimitiveFunction.ToFloat.OfFloat fn) {
        imp.replaceAllFloat(fn);
    }

    @Override
    public boolean removeIfFloat(jdk.prim.util.function.PrimitivePredicate.OfFloat filter) {
        assessModability();
        return imp.removeIfFloat(filter);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        assessModability();
        boolean modified = false;
        var it = iteratorFloat();
        while (it.hasNext()) {
            if (!c.contains(it.nextFloat())) {
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
    public boolean addFloat(float element) {
        assessModability();
        return imp.addFloat(element);
    }

    @Override
    public boolean addAllFloat(jdk.prim.util.PrimitiveCollection.OfFloat c) {
        assessModability();
        if(c.size() == 0) return false;
        var it = c.iteratorFloat();
        while(it.hasNext()) imp.addFloat(0, it.nextFloat());
        return true;
    }

    @Override
    public boolean containsFloat(float element) {
        return imp.containsFloat(element);
    }

    @Override
    public boolean containsAllFloat(jdk.prim.util.PrimitiveCollection.OfFloat c) {
        return imp.containsAllFloat(c);
    }

    @Override
    public jdk.prim.util.stream.PrimitiveStream.OfFloat parallelStreamFloat() {
        // TODO Will be implemented when primitive streams and splitterator are implemented
        throw new UnsupportedOperationException("Unimplemented method 'parallelStreamFloat'");
    }

    @Override
    public boolean removeAllFloat(jdk.prim.util.PrimitiveCollection.OfFloat c) {
        assessModability();
        boolean modified = false;
        var it = iteratorFloat();
        while (it.hasNext()) {
            if (c.containsFloat(it.nextFloat())) {
                it.remove();
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean retainAllFloat(jdk.prim.util.PrimitiveCollection.OfFloat c) {
        assessModability();
        boolean modified = false;
        var it = iteratorFloat();
        while (it.hasNext()) {
            if (!c.containsFloat(it.nextFloat())) {
                it.remove();
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public jdk.prim.util.stream.PrimitiveStream.OfFloat streamFloat() {
        // TODO Will be implemented when primitive streams and splitterator are implemented
        throw new UnsupportedOperationException("Unimplemented method 'streamFloat'");
    }

    @Override
    public float[] toArrayFloat() {
        return PrimitiveArrays.reverse(imp.toArrayFloat());
    }

    @Override
    public jdk.prim.util.PrimitiveIterator.OfFloat iteratorFloat() {
        return new DIterator();
    }

    @Override
    public void addFloat(int index, float e) {
        assessModability();
        int l = imp.size();
        checkClosedRange(index, l);
        imp.addFloat(l - index, e);
    }

    @Override
    public float getFloat(int index) {
        int size = imp.size();
        Objects.checkIndex(index, size);
        return imp.getFloat(size - index - 1);
    }

    @Override
    public int indexOfFloat(float e) {
        int i = imp.lastIndexOfFloat(e);
        return i == -1 ? -1 : imp.size() - i - 1;
    }

    @Override
    public int lastIndexOfFloat(float e) {
        int i = imp.indexOfFloat(e);
        return i == -1 ? -1 : imp.size() - i - 1;
    }

    @Override
    public jdk.prim.util.PrimitiveListIterator.OfFloat listIteratorFloat() {
        return new DLIterator(size(), 0);
    }

    @Override
    public jdk.prim.util.PrimitiveListIterator.OfFloat listIteratorFloat(int from) {
        int size = size();
        checkClosedRange(from, size);
        return new DLIterator(size, from);
    }

    @Override
    public float removeElementAtIndex(int i) {
        assessModability();
        int size = imp.size();
        Objects.checkIndex(i, size);
        return imp.removeElementAtIndex(size - i - 1);
    }

    @Override
    public boolean removeFloat(float e) {
        assessModability();
        var it = iteratorFloat();
        while (it.hasNext()) {
            if (e == it.nextFloat()) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public float setFloat(int index, float e) {
        assessModability();
        int size = imp.size();
        Objects.checkIndex(index, size);
        return imp.setFloat(size - index - 1, e);
    }

    @Override
    public jdk.prim.util.PrimitiveList.OfFloat subListFloat(int from, int to) {
        int size = imp.size();
        Objects.checkFromToIndex(from, to, size);
        return new jdk.prim.util.rolv.OfFloat(imp.subListFloat(size - to, size - from), isMod);
    }

    @Override
    public java.lang.Float[] toArray() {
        return PrimitiveArrays.reverse(imp.toArray());
    }

    @Override
    public boolean addAllFloat(int index, jdk.prim.util.PrimitiveCollection.OfFloat e) {
        assessModability();
        int size = imp.size();
        checkClosedRange(index, size);
        var it = iteratorFloat();
        if(!it.hasNext()) return false;
        while(it.hasNext()) imp.addFloat(size - index, it.nextFloat());
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof List))
            return false;

        var e1 = listIteratorFloat();
        var e2 = ((List<?>) obj).listIterator();
        while (e1.hasNext() && e2.hasNext()) {
            float o1 = e1.nextFloat();
            Object o2 = e2.next();
            if (!o2.equals(o1))
                return false;
        }
        return !(e1.hasNext() || e2.hasNext());
    }

    @Override
    public int hashCode() {
        int hashCode = 1;
        var it = iteratorFloat();
        while(it.hasNext()) hashCode = 31 * hashCode + java.lang.Float.hashCode(it.nextFloat());
        return hashCode;
    }

    @Override
    public String toString() {
        var it = iteratorFloat();
        if (!it.hasNext())
            return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (;;) {
            float e = it.nextFloat();
            sb.append(e);
            if (!it.hasNext())
                return sb.append(']').toString();
            sb.append(',').append(' ');
        }
    }

    @Override
    public float[] toArrayFloat(float[] array) {
        var rev = toArrayFloat();
        if(array.length < rev.length) return rev;
        System.arraycopy(rev, 0, array, 0, rev.length);
        return array;
    }

    @Override
    public float[] toArrayFloat(jdk.prim.util.function.PrimitiveFunction.OfInt<float[]> generator) {
        return PrimitiveArrays.reverse(imp.toArrayFloat(generator));
    }

    @Override
    public void sortFloat(jdk.prim.util.PrimitiveComparator.OfFloat c) {
        assessModability();
        jdk.prim.util.PrimitiveList.OfFloat.super.sortFloat(c.reversedFloat());
    }
    
}
