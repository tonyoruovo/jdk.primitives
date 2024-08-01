package jdk.prim.util.rolv;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

import jdk.prim.util.PrimitiveIterator;
import jdk.prim.util.PrimitiveIterators;
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

        public void add(double e) {
            assessModability();
            it.addDouble(e);
            it.previousDouble();
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

    @Override
    public void forEach(jdk.prim.util.function.PrimitiveConsumer.OfDouble action) {
        var it = iteratorDouble();
        while(it.hasNext()) {
            action.acceptDouble(it.nextDouble());
        }
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    @Override
    public boolean isEmpty() {
        return imp.isEmpty();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toArray'");
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addAll'");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeAll'");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'retainAll'");
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeAllDouble'");
    }

    @Override
    public boolean retainAllDouble(jdk.prim.util.PrimitiveCollection.OfDouble c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'retainAllDouble'");
    }

    @Override
    public jdk.prim.util.stream.PrimitiveStream.OfDouble streamDouble() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'streamDouble'");
    }

    @Override
    public double[] toArrayDouble() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toArrayDouble'");
    }

    @Override
    public jdk.prim.util.PrimitiveIterator.OfDouble iteratorDouble() {
        return new DIterator();
    }

    @Override
    public void addDouble(int index, double e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addDouble'");
    }

    @Override
    public double getDouble(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDouble'");
    }

    @Override
    public int indexOfDouble(double e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'indexOfDouble'");
    }

    @Override
    public int lastIndexOfDouble(double e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'lastIndexOfDouble'");
    }

    @Override
    public jdk.prim.util.PrimitiveListIterator.OfDouble listIteratorDouble() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listIteratorDouble'");
    }

    @Override
    public jdk.prim.util.PrimitiveListIterator.OfDouble listIteratorDouble(int from) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listIteratorDouble'");
    }

    @Override
    public double removeElementAtIndex(int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeElementAtIndex'");
    }

    @Override
    public boolean removeDouble(double e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeDouble'");
    }

    @Override
    public double setDouble(int index, double e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setDouble'");
    }

    @Override
    public jdk.prim.util.PrimitiveList.OfDouble subListDouble(int from, int to) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'subListDouble'");
    }

    @Override
    public java.lang.Double[] toArray() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toArray'");
    }

    @Override
    public boolean addAllDouble(int index, jdk.prim.util.PrimitiveCollection.OfDouble e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addAllDouble'");
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
        // TODO Auto-generated method stub
        return super.toString();
    }
    
}
