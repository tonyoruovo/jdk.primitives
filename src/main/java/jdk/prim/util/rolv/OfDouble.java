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

public class OfDouble implements PrimitiveList.OfDouble {

    private static class Rand extends jdk.prim.util.rolv.OfDouble implements RandomAccess {

        public Rand(PrimitiveList.OfDouble list, boolean modifiable) {
            super(list, modifiable);
        }
    }

    class DIterator implements PrimitiveIterator.OfDouble {
        final PrimitiveListIterator.OfDouble it = imp.listIteratorDouble(imp.size());
        public boolean hasNext() { return it.hasPrevious(); }
        public double nextDouble() { return it.previousDouble(); }
        public void remove() {
            assessModability();
            it.remove();
        }
    }

    class DLIterator implements PrimitiveListIterator.OfDouble {
        
        final PrimitiveListIterator.OfDouble it;

        DLIterator(int size, int pos) {
            if (pos < 0 || pos > size)
                throw new IndexOutOfBoundsException();
            it = imp.listIteratorDouble(size - pos);
        }

        public boolean hasNext() {
            return it.hasPrevious();
        }

        public double nextDouble() {
            return it.previousDouble();
        }

        public boolean hasPrevious() {
            return it.hasNext();
        }

        public double previousDouble() {
            return it.nextDouble();
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

        public void setDouble(double e) {
            assessModability();
            it.setDouble(e);
        }

        public void addDouble(double e) {
            assessModability();
            it.addDouble(e);
            it.previousDouble();
        }
    
    }

    public static PrimitiveList.OfDouble of(PrimitiveList.OfDouble list, boolean modifiable) {
        if (list instanceof jdk.prim.util.rolv.OfDouble rolv) {
            return rolv.imp;
        } else if (list instanceof RandomAccess) {
            return new jdk.prim.util.rolv.OfDouble.Rand(list, modifiable);
        } else {
            return new jdk.prim.util.rolv.OfDouble(list, modifiable);
        }
    }

    //implementation
    private PrimitiveList.OfDouble imp;
    private boolean isMod;

    public OfDouble(PrimitiveList.OfDouble list, boolean modifiable) {
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
    public void forEach(jdk.prim.util.function.PrimitiveConsumer.OfDouble action) {
        var it = iteratorDouble();
        while(it.hasNext()) {
            action.acceptDouble(it.nextDouble());
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
    public boolean addAll(Collection<? extends java.lang.Double> c) {
        assessModability();
        if(c.size() == 0) return false;
        var it = c.iterator();
        while(it.hasNext()) imp.add(0, it.next());
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends java.lang.Double> c) {
        assessModability();
        int size = imp.size();
        checkClosedRange(index, size);
        var adds = (java.lang.Double[]) c.toArray();
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
        var it = iteratorDouble();
        while (it.hasNext()) {
            if (c.contains(it.nextDouble())) {
                it.remove();
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public void replaceAllDouble(jdk.prim.util.function.PrimitiveFunction.ToDouble.OfDouble fn) {
        imp.replaceAllDouble(fn);
    }

    @Override
    public boolean removeIfDouble(jdk.prim.util.function.PrimitivePredicate.OfDouble filter) {
        assessModability();
        return imp.removeIfDouble(filter);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        assessModability();
        boolean modified = false;
        var it = iteratorDouble();
        while (it.hasNext()) {
            if (!c.contains(it.nextDouble())) {
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
    public boolean addDouble(double element) {
        assessModability();
        return imp.addDouble(element);
    }

    @Override
    public boolean addAllDouble(jdk.prim.util.PrimitiveCollection.OfDouble c) {
        assessModability();
        if(c.size() == 0) return false;
        var it = c.iteratorDouble();
        while(it.hasNext()) imp.addDouble(0, it.nextDouble());
        return true;
    }

    @Override
    public boolean containsDouble(double element) {
        return imp.containsDouble(element);
    }

    @Override
    public boolean containsAllDouble(jdk.prim.util.PrimitiveCollection.OfDouble c) {
        return imp.containsAllDouble(c);
    }

    @Override
    public jdk.prim.util.stream.PrimitiveStream.OfDouble parallelStreamDouble() {
        // TODO Will be implemented when primitive streams and splitterator are implemented
        throw new UnsupportedOperationException("Unimplemented method 'parallelStreamDouble'");
    }

    @Override
    public boolean removeAllDouble(jdk.prim.util.PrimitiveCollection.OfDouble c) {
        assessModability();
        boolean modified = false;
        var it = iteratorDouble();
        while (it.hasNext()) {
            if (c.containsDouble(it.nextDouble())) {
                it.remove();
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean retainAllDouble(jdk.prim.util.PrimitiveCollection.OfDouble c) {
        assessModability();
        boolean modified = false;
        var it = iteratorDouble();
        while (it.hasNext()) {
            if (!c.containsDouble(it.nextDouble())) {
                it.remove();
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public jdk.prim.util.stream.PrimitiveStream.OfDouble streamDouble() {
        // TODO Will be implemented when primitive streams and splitterator are implemented
        throw new UnsupportedOperationException("Unimplemented method 'streamDouble'");
    }

    @Override
    public double[] toArrayDouble() {
        return PrimitiveArrays.reverse(imp.toArrayDouble());
    }

    @Override
    public jdk.prim.util.PrimitiveIterator.OfDouble iteratorDouble() {
        return new DIterator();
    }

    @Override
    public void addDouble(int index, double e) {
        assessModability();
        int l = imp.size();
        checkClosedRange(index, l);
        imp.addDouble(l - index, e);
    }

    @Override
    public double getDouble(int index) {
        int size = imp.size();
        Objects.checkIndex(index, size);
        return imp.getDouble(size - index - 1);
    }

    @Override
    public int indexOfDouble(double e) {
        int i = imp.lastIndexOfDouble(e);
        return i == -1 ? -1 : imp.size() - i - 1;
    }

    @Override
    public int lastIndexOfDouble(double e) {
        int i = imp.indexOfDouble(e);
        return i == -1 ? -1 : imp.size() - i - 1;
    }

    @Override
    public jdk.prim.util.PrimitiveListIterator.OfDouble listIteratorDouble() {
        return new DLIterator(size(), 0);
    }

    @Override
    public jdk.prim.util.PrimitiveListIterator.OfDouble listIteratorDouble(int from) {
        int size = size();
        checkClosedRange(from, size);
        return new DLIterator(size, from);
    }

    @Override
    public double removeElementAtIndex(int i) {
        assessModability();
        int size = imp.size();
        Objects.checkIndex(i, size);
        return imp.removeElementAtIndex(size - i - 1);
    }

    @Override
    public boolean removeDouble(double e) {
        assessModability();
        var it = iteratorDouble();
        while (it.hasNext()) {
            if (e == it.nextDouble()) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public double setDouble(int index, double e) {
        assessModability();
        int size = imp.size();
        Objects.checkIndex(index, size);
        return imp.setDouble(size - index - 1, e);
    }

    @Override
    public jdk.prim.util.PrimitiveList.OfDouble subListDouble(int from, int to) {
        int size = imp.size();
        Objects.checkFromToIndex(from, to, size);
        return new jdk.prim.util.rolv.OfDouble(imp.subListDouble(size - to, size - from), isMod);
    }

    @Override
    public java.lang.Double[] toArray() {
        return PrimitiveArrays.reverse(imp.toArray());
    }

    @Override
    public boolean addAllDouble(int index, jdk.prim.util.PrimitiveCollection.OfDouble e) {
        assessModability();
        int size = imp.size();
        checkClosedRange(index, size);
        var it = iteratorDouble();
        if(!it.hasNext()) return false;
        while(it.hasNext()) imp.addDouble(size - index, it.nextDouble());
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof List))
            return false;

        var e1 = listIteratorDouble();
        var e2 = ((List<?>) obj).listIterator();
        while (e1.hasNext() && e2.hasNext()) {
            double o1 = e1.nextDouble();
            Object o2 = e2.next();
            if (!o2.equals(o1))
                return false;
        }
        return !(e1.hasNext() || e2.hasNext());
    }

    @Override
    public int hashCode() {
        int hashCode = 1;
        var it = iteratorDouble();
        while(it.hasNext()) hashCode = 31 * hashCode + java.lang.Double.hashCode(it.nextDouble());
        return hashCode;
    }

    @Override
    public String toString() {
        var it = iteratorDouble();
        if (!it.hasNext())
            return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (;;) {
            double e = it.nextDouble();
            sb.append(e);
            if (!it.hasNext())
                return sb.append(']').toString();
            sb.append(',').append(' ');
        }
    }

    @Override
    public double[] toArrayDouble(double[] array) {
        var rev = toArrayDouble();
        if(array.length < rev.length) return rev;
        System.arraycopy(rev, 0, array, 0, rev.length);
        return array;
    }

    @Override
    public double[] toArrayDouble(jdk.prim.util.function.PrimitiveFunction.OfInt<double[]> generator) {
        return PrimitiveArrays.reverse(imp.toArrayDouble(generator));
    }

    @Override
    public void sortDouble(jdk.prim.util.PrimitiveComparator.OfDouble c) {
        assessModability();
        jdk.prim.util.PrimitiveList.OfDouble.super.sortDouble(c.reversedDouble());
    }
    
}
