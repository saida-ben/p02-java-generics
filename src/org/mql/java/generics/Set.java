package org.mql.java.generics;

import java.util.Iterator;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

public class Set<T> implements Iterable<T>{
    private Object[] elements; // Tableau pour stocker les éléments
    private int size; // Taille de l'ensemble

    // Constructeur
    public Set() {
        elements = new Object[10]; // Taille initiale du tableau
        size = 0;
    }

    // Méthode pour ajouter un élément dans l'ensemble (unicité)
    public boolean add(T element) {
        if (contains(element)) {
            return false; // Empêcher l'ajout si l'élément existe déjà
        }

        // Si le tableau est plein, on le redimensionne
        if (size == elements.length) {
            resize();
        }

        // Ajouter l'élément
        elements[size++] = element;
        return true;
    }

    // Méthode pour redimensionner le tableau quand il est plein
    private void resize() {
        Object[] newArray = new Object[elements.length * 2];
        System.arraycopy(elements, 0, newArray, 0, elements.length);
        elements = newArray;
    }

    // Méthode pour vérifier si l'élément est présent dans l'ensemble
    
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    // Méthode pour supprimer un élément de l'ensemble
    
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                // Décalage des éléments après la suppression
                System.arraycopy(elements, i + 1, elements, i, size - i - 1);
                elements[--size] = null; // Libère la référence de l'élément supprimé
                return true;
            }
        }
        return false;
    }

    // Méthode pour récupérer la taille de l'ensemble
   
    public int size() {
        return size;
    }

    // Méthode pour vérifier si l'ensemble est vide
   
    public boolean isEmpty() {
        return size == 0;
    }

    // Méthode pour vider l'ensemble
    
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    // Méthode pour obtenir l'élément à un index donné
    
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index hors limites");
        }
        return (T) elements[index];
    }

    // Méthode pour itérer sur les éléments de l'ensemble
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) elements[currentIndex++];
            }
        };
    }

    // Méthode pour ajouter une collection d'éléments
    
    public boolean addAll(Collection<? extends T> c) {
        boolean modified = false;
        for (T element : c) {
            if (add(element)) {
                modified = true;
            }
        }
        return modified;
    }

    // Méthode pour obtenir un tableau d'éléments
    
    public Object[] toArray() {
        Object[] array = new Object[size];
        System.arraycopy(elements, 0, array, 0, size);
        return array;
    }

    
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Object element : c) {
            if (remove(element)) {
                modified = true;
            }
        }
        return modified;
    }

    // Autres méthodes nécessaires pour implémenter List (non utilisées directement ici)
    
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (elements[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    
    public void add(int index, T element) {
        throw new UnsupportedOperationException();
    }

    
    public T set(int index, T element) {
        throw new UnsupportedOperationException();
    }

    
    public T remove(int index) {
        throw new UnsupportedOperationException();
    }

    
    public boolean containsAll(Collection<?> c) {
        for (Object element : c) {
            if (!contains(element)) {
                return false;
            }
        }
        return true;
    }

    
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        for (int i = 0; i < size; i++) {
            if (!c.contains(elements[i])) {
                remove(elements[i]);
                modified = true;
            }
        }
        return modified;
    }

    
    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    
    public java.util.ListIterator<T> listIterator() {
        throw new UnsupportedOperationException();
    }

    
    public java.util.ListIterator<T> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            // Si le tableau passé en paramètre est trop petit, on crée un nouveau tableau
            return (T[]) java.util.Arrays.copyOf(elements, size, a.getClass());
        }
        System.arraycopy(elements, 0, a, 0, size);
        if (a.length > size) {
            a[size] = null; // Null à la fin pour respecter la taille exacte
        }
        return a;
    }

    // Méthode pour afficher les éléments sous forme de chaîne
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
