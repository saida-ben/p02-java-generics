package org.mql.java.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements List<T>, Iterable<T> {
    private T value;
    private LinkedList<T> next;

    public LinkedList() {
        value = null;
        next = null;
    }

    public LinkedList(T value) {
        this.value = value;
        next = null;
    }

    @Override
    public void add(T e) {
        if (value == null && next == null) {
            value = e;
        } else if (next == null) {
            next = new LinkedList<T>(e);
        } else {
            next.add(e);
        }
    }

    @Override
    public T remove(int index) {
        if (index == 0) {
            if (next == null) {
                T removed = value;
                value = null;
                next = null;
                return removed;
            } else {
                T removed = value;
                value = next.value;
                next = next.next;
                return removed;
            }
        }
        if (next == null) {
            return null;
        }
        return next.remove(index - 1);
    }

    @Override
    public T get(int index) {
        if (value == null) return null;
        if (index == 0) return value;
        if (next == null) return null;
        return next.get(index - 1);
    }

    @Override
    public int size() {
        if (value == null) return 0;
        return 1 + (next != null ? next.size() : 0);
    }

    @Override
    public boolean contains(T e) {
        if (value == null) return false;
        if (value.equals(e)) return true;
        if (next == null) return false;
        return next.contains(e);
    }

    @Override
    public int indexOf(T e) {
        return indexOfHelper(e, 0);
    }

    private int indexOfHelper(T e, int index) {
        if (value == null) return -1;
        if (value.equals(e)) return index;
        if (next == null) return -1;
        return next.indexOfHelper(e, index + 1);
    }

    @Override
    public void reverse() {
        reverseHelper(null);
    }

    private void reverseHelper(LinkedList<T> prev) {
        if (next == null) {
            value = prev.value;
            next = prev.next;
            return;
        }
        LinkedList<T> temp = next;
        next = prev;
        reverseHelper(temp);
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size()];
        toArrayHelper(array, 0);
        return array;
    }

    private void toArrayHelper(Object[] array, int index) {
        if (value == null) return;
        array[index] = value;
        if (next != null) {
            next.toArrayHelper(array, index + 1);
        }
    }

    @Override
    public T removeLast() {
        if (next == null) {
            T removed = value;
            value = null;
            return removed;
        }
        return next.removeLast();
    }

    @Override
    public T removeFirst() {
        if (value == null) return null;
        T removed = value;
        value = next != null ? next.value : null;
        next = next != null ? next.next : null;
        return removed;
    }

    @Override
    public void set(int index, T e) {
        if (index == 0) {
            value = e;
        } else if (next != null) {
            next.set(index - 1, e);
        } else {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds.");
        }
    }

    @Override
    public void clear() {
        value = null;
        next = null;
    }

    @Override
    public boolean isEmpty() {
        return value == null && next == null;
    }

    @Override
    public int sizeRecursive() {
        return sizeRecursiveHelper(0);
    }

    private int sizeRecursiveHelper(int count) {
        if (value == null) return count;
        if (next == null) return count + 1;
        return next.sizeRecursiveHelper(count + 1);
    }

    @Override
    public void addAll(List<T> other) {
        Iterator<T> iterator = other.iterator();
        while (iterator.hasNext()) {
            add(iterator.next());
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iter(this);
    }

    class Iter implements Iterator<T> {
        private LinkedList<T> pointer;

        public Iter(LinkedList<T> pointer) {
            this.pointer = pointer;
        }

        @Override
        public boolean hasNext() {
            return pointer != null && pointer.value != null;
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException("No more elements.");
            T element = pointer.value;
            pointer = pointer.next;
            return element;
        }
    }
}
