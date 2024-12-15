package org.mql.java.generics;
import java.util.Iterator;

public class Vector<T> implements List<T>, Iterable<T> {
    private Object[] elements;
    private int size;

    // Taille initiale par défaut
    private static final int DEFAULT_CAPACITY = 10;

    // Constructeur par défaut
    public Vector() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    // Constructeur avec une capacité initiale
    public Vector(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than zero.");
        }
        elements = new Object[initialCapacity];
        size = 0;
    }

    @Override
    public void add(T element) {
        ensureCapacity();
        elements[size++] = element;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        checkIndex(index);
        return (T) elements[index];
    }

    @Override
    @SuppressWarnings("unchecked")
    public T remove(int index) {
        checkIndex(index);
        T removedElement = (T) elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null; // Éviter les fuites de mémoire
        return removedElement;
    }

    @Override
    public void set(int index, T element) {
        checkIndex(index);
        elements[index] = element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    // Redimensionner si nécessaire
    private void ensureCapacity() {
        if (size == elements.length) {
            Object[] newElements = new Object[elements.length * 2];
            System.arraycopy(elements, 0, newElements, 0, elements.length);
            elements = newElements;
        }
    }

    // Vérifie si l'index est valide
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }
    
    @Override
    public int indexOf(T e) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(e)) {
                return i;
            }
        }
        return -1; // Retourner -1 si l'élément n'est pas trouvé
    }

    // Inverser les éléments du vecteur
    @Override
    public void reverse() {
        int left = 0;
        int right = size - 1;
        while (left < right) {
            Object temp = elements[left];
            elements[left] = elements[right];
            elements[right] = temp;
            left++;
            right--;
        }
    }

    // Supprimer le premier élément du vecteur
    @Override
    public T removeFirst() {
        if (isEmpty()) return null;
        T removedElement = (T) elements[0];
        for (int i = 0; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null;
        return removedElement;
    }

    // Supprimer le dernier élément du vecteur
    @Override
    public T removeLast() {
        if (isEmpty()) return null;
        T removedElement = (T) elements[--size];
        elements[size] = null; // Éviter les fuites de mémoire
        return removedElement;
    }

    // Retourner un tableau contenant tous les éléments
    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        System.arraycopy(elements, 0, array, 0, size);
        return array;
    }

    // Calculer la taille de manière récursive
    @Override
    public int sizeRecursive() {
        return sizeRecursiveHelper(0);
    }

    private int sizeRecursiveHelper(int index) {
        if (index >= size) {
            return 0;
        }
        return 1 + sizeRecursiveHelper(index + 1);
    }

    // Ajouter tous les éléments d'une autre liste
    @Override
    public void addAll(List<T> other) {
        Iterator<T> iterator = other.iterator();
        while (iterator.hasNext()) {
            add(iterator.next());
        }
    }

    // Implémentation de l'itérateur
    @Override
    public Iterator<T> iterator() {
        return new VectorIterator();
    }

    private class VectorIterator implements Iterator<T> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @SuppressWarnings("unchecked")
        @Override
        public T next() {
            return (T) elements[currentIndex++];
        }
    }


	
}