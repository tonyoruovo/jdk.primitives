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

public class OfChar implements PrimitiveList.OfChar {

    private static class Rand extends jdk.prim.util.rolv.OfChar implements RandomAccess {

        public Rand(PrimitiveList.OfChar list, boolean modifiable) {
            super(list, modifiable);
        }
    }

    class DIterator implements PrimitiveIterator.OfChar {
        final PrimitiveListIterator.OfChar it = imp.listIteratorChar(imp.size());
        public boolean hasNext() { return it.hasPrevious(); }
        public char nextChar() { return it.previousChar(); }
        public void remove() {
            assessModability();
            it.remove();
        }
    }

    class DLIterator implements PrimitiveListIterator.OfChar {
        
        final PrimitiveListIterator.OfChar it;

        DLIterator(int size, int pos) {
            if (pos < 0 || pos > size)
                throw new IndexOutOfBoundsException();
            it = imp.listIteratorChar(size - pos);
        }

        public boolean hasNext() {
            return it.hasPrevious();
        }

        public char nextChar() {
            return it.previousChar();
        }

        public boolean hasPrevious() {
            return it.hasNext();
        }

        public char previousChar() {
            return it.nextChar();
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

        public void setChar(char e) {
            assessModability();
            it.setChar(e);
        }

        public void addChar(char e) {
            assessModability();
            it.addChar(e);
            it.previousChar();
        }
    
    }

    public static PrimitiveList.OfChar of(PrimitiveList.OfChar list, boolean modifiable) {
        if (list instanceof jdk.prim.util.rolv.OfChar rolv) {
            return rolv.imp;
        } else if (list instanceof RandomAccess) {
            return new jdk.prim.util.rolv.OfChar.Rand(list, modifiable);
        } else {
            return new jdk.prim.util.rolv.OfChar(list, modifiable);
        }
    }

    //implementation
    private PrimitiveList.OfChar imp;
    private boolean isMod;

    public OfChar(PrimitiveList.OfChar list, boolean modifiable) {
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
    public void forEach(jdk.prim.util.function.PrimitiveConsumer.OfChar action) {
        var it = iteratorChar();
        while(it.hasNext()) {
            action.acceptChar(it.nextChar());
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
    public boolean addAll(Collection<? extends java.lang.Character> c) {
        assessModability();
        if(c.size() == 0) return false;
        var it = c.iterator();
        while(it.hasNext()) imp.add(0, it.next());
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends java.lang.Character> c) {
        assessModability();
        int size = imp.size();
        checkClosedRange(index, size);
        var adds = (java.lang.Character[]) c.toArray();
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
        var it = iteratorChar();
        while (it.hasNext()) {
            if (c.contains(it.nextChar())) {
                it.remove();
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public void replaceAllChar(jdk.prim.util.function.PrimitiveFunction.ToChar.OfChar fn) {
        imp.replaceAllChar(fn);
    }

    @Override
    public boolean removeIfChar(jdk.prim.util.function.PrimitivePredicate.OfChar filter) {
        assessModability();
        return imp.removeIfChar(filter);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        assessModability();
        boolean modified = false;
        var it = iteratorChar();
        while (it.hasNext()) {
            if (!c.contains(it.nextChar())) {
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
    public boolean addChar(char element) {
        assessModability();
        return imp.addChar(element);
    }

    @Override
    public boolean addAllChar(jdk.prim.util.PrimitiveCollection.OfChar c) {
        assessModability();
        if(c.size() == 0) return false;
        var it = c.iteratorChar();
        while(it.hasNext()) imp.addChar(0, it.nextChar());
        return true;
    }

    @Override
    public boolean containsChar(char element) {
        return imp.containsChar(element);
    }

    @Override
    public boolean containsAllChar(jdk.prim.util.PrimitiveCollection.OfChar c) {
        return imp.containsAllChar(c);
    }

    @Override
    public jdk.prim.util.stream.PrimitiveStream.OfChar parallelStreamChar() {
        // TODO Will be implemented when primitive streams and splitterator are implemented
        throw new UnsupportedOperationException("Unimplemented method 'parallelStreamChar'");
    }

    @Override
    public boolean removeAllChar(jdk.prim.util.PrimitiveCollection.OfChar c) {
        assessModability();
        boolean modified = false;
        var it = iteratorChar();
        while (it.hasNext()) {
            if (c.containsChar(it.nextChar())) {
                it.remove();
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean retainAllChar(jdk.prim.util.PrimitiveCollection.OfChar c) {
        assessModability();
        boolean modified = false;
        var it = iteratorChar();
        while (it.hasNext()) {
            if (!c.containsChar(it.nextChar())) {
                it.remove();
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public jdk.prim.util.stream.PrimitiveStream.OfChar streamChar() {
        // TODO Will be implemented when primitive streams and splitterator are implemented
        throw new UnsupportedOperationException("Unimplemented method 'streamChar'");
    }

    @Override
    public char[] toArrayChar() {
        return PrimitiveArrays.reverse(imp.toArrayChar());
    }

    @Override
    public jdk.prim.util.PrimitiveIterator.OfChar iteratorChar() {
        return new DIterator();
    }

    @Override
    public void addChar(int index, char e) {
        assessModability();
        int l = imp.size();
        checkClosedRange(index, l);
        imp.addChar(l - index, e);
    }

    @Override
    public char getChar(int index) {
        int size = imp.size();
        Objects.checkIndex(index, size);
        return imp.getChar(size - index - 1);
    }

    @Override
    public int indexOfChar(char e) {
        int i = imp.lastIndexOfChar(e);
        return i == -1 ? -1 : imp.size() - i - 1;
    }

    @Override
    public int lastIndexOfChar(char e) {
        int i = imp.indexOfChar(e);
        return i == -1 ? -1 : imp.size() - i - 1;
    }

    @Override
    public jdk.prim.util.PrimitiveListIterator.OfChar listIteratorChar() {
        return new DLIterator(size(), 0);
    }

    @Override
    public jdk.prim.util.PrimitiveListIterator.OfChar listIteratorChar(int from) {
        int size = size();
        checkClosedRange(from, size);
        return new DLIterator(size, from);
    }

    @Override
    public char removeElementAtIndex(int i) {
        assessModability();
        int size = imp.size();
        Objects.checkIndex(i, size);
        return imp.removeElementAtIndex(size - i - 1);
    }

    @Override
    public boolean removeChar(char e) {
        assessModability();
        var it = iteratorChar();
        while (it.hasNext()) {
            if (e == it.nextChar()) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public char setChar(int index, char e) {
        assessModability();
        int size = imp.size();
        Objects.checkIndex(index, size);
        return imp.setChar(size - index - 1, e);
    }

    @Override
    public jdk.prim.util.PrimitiveList.OfChar subListChar(int from, int to) {
        int size = imp.size();
        Objects.checkFromToIndex(from, to, size);
        return new jdk.prim.util.rolv.OfChar(imp.subListChar(size - to, size - from), isMod);
    }

    @Override
    public java.lang.Character[] toArray() {
        return PrimitiveArrays.reverse(imp.toArray());
    }

    @Override
    public boolean addAllChar(int index, jdk.prim.util.PrimitiveCollection.OfChar e) {
        assessModability();
        int size = imp.size();
        checkClosedRange(index, size);
        var it = iteratorChar();
        if(!it.hasNext()) return false;
        while(it.hasNext()) imp.addChar(size - index, it.nextChar());
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof List))
            return false;

        var e1 = listIteratorChar();
        var e2 = ((List<?>) obj).listIterator();
        while (e1.hasNext() && e2.hasNext()) {
            char o1 = e1.nextChar();
            Object o2 = e2.next();
            if (!o2.equals(o1))
                return false;
        }
        return !(e1.hasNext() || e2.hasNext());
    }

    @Override
    public int hashCode() {
        int hashCode = 1;
        var it = iteratorChar();
        while(it.hasNext()) hashCode = 31 * hashCode + java.lang.Character.hashCode(it.nextChar());
        return hashCode;
    }

    @Override
    public String toString() {
        var it = iteratorChar();
        if (!it.hasNext())
            return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (;;) {
            char e = it.nextChar();
            sb.append(e);
            if (!it.hasNext())
                return sb.append(']').toString();
            sb.append(',').append(' ');
        }
    }

    @Override
    public char[] toArrayChar(char[] array) {
        var rev = toArrayChar();
        if(array.length < rev.length) return rev;
        System.arraycopy(rev, 0, array, 0, rev.length);
        return array;
    }

    @Override
    public char[] toArrayChar(jdk.prim.util.function.PrimitiveFunction.OfInt<char[]> generator) {
        return PrimitiveArrays.reverse(imp.toArrayChar(generator));
    }

    @Override
    public void sortChar(jdk.prim.util.PrimitiveComparator.OfChar c) {
        assessModability();
        jdk.prim.util.PrimitiveList.OfChar.super.sortChar(c.reversedChar());
    }
    
}
