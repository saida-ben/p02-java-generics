package org.mql.java.generics;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VectorTest {

    @Test
    void testAddAndSize() {
        Vector<Integer> vector = new Vector<>();
        vector.add(10);
        vector.add(20);
        assertEquals(2, vector.size(), "La taille doit être 2 après l'ajout de deux éléments.");
    }

    @Test
    void testGet() {
        Vector<Integer> vector = new Vector<>();
        vector.add(10);
        vector.add(20);
        assertEquals(20, vector.get(1), "L'élément à l'index 1 doit être 20.");
    }

    @Test
    void testGetOutOfBounds() {
        Vector<Integer> vector = new Vector<>();
        vector.add(10);
        assertThrows(IndexOutOfBoundsException.class, () -> vector.get(2), "Une exception IndexOutOfBounds doit être levée pour un index invalide.");
    }

    @Test
    void testRemove() {
        Vector<Integer> vector = new Vector<>();
        vector.add(10);
        vector.add(20);
        Integer removed = vector.remove(0);
        assertEquals(10, removed, "L'élément supprimé doit être 10.");
        assertEquals(1, vector.size(), "La taille doit être 1 après la suppression d'un élément.");
    }

    @Test
    void testRemoveOutOfBounds() {
        Vector<Integer> vector = new Vector<>();
        vector.add(10);
        assertThrows(IndexOutOfBoundsException.class, () -> vector.remove(2), "Une exception IndexOutOfBounds doit être levée pour un index invalide.");
    }

    @Test
    void testSet() {
        Vector<Integer> vector = new Vector<>();
        vector.add(10);
        vector.add(20);
        vector.set(1, 30);
        assertEquals(30, vector.get(1), "L'élément à l'index 1 doit être remplacé par 30.");
    }

    @Test
    void testSetOutOfBounds() {
        Vector<Integer> vector = new Vector<>();
        vector.add(10);
        assertThrows(IndexOutOfBoundsException.class, () -> vector.set(2, 30), "Une exception IndexOutOfBounds doit être levée pour un index invalide.");
    }

    @Test
    void testIsEmpty() {
        Vector<Integer> vector = new Vector<>();
        assertTrue(vector.isEmpty(), "La liste doit être vide.");
        vector.add(10);
        assertFalse(vector.isEmpty(), "La liste ne doit pas être vide après l'ajout d'un élément.");
    }

    @Test
    void testContains() {
        Vector<Integer> vector = new Vector<>();
        vector.add(10);
        assertTrue(vector.contains(10), "La liste doit contenir l'élément 10.");
        assertFalse(vector.contains(20), "La liste ne doit pas contenir l'élément 20.");
    }

    @Test
    void testClear() {
        Vector<Integer> vector = new Vector<>();
        vector.add(10);
        vector.add(20);
        vector.clear();
        assertTrue(vector.isEmpty(), "La liste doit être vide après l'appel à clear().");
    }

    @Test
    void testToArray() {
        Vector<Integer> vector = new Vector<>();
        vector.add(10);
        vector.add(20);
        Object[] array = vector.toArray();
        assertArrayEquals(new Object[]{10, 20}, array, "Le tableau retourné doit contenir les éléments 10 et 20.");
    }

    @Test
    void testIndexOf() {
        Vector<Integer> vector = new Vector<>();
        vector.add(10);
        vector.add(20);
        assertEquals(1, vector.indexOf(20), "L'index de l'élément 20 doit être 1.");
        assertEquals(-1, vector.indexOf(30), "L'élément 30 ne doit pas exister, donc son index doit être -1.");
    }

    @Test
    void testReverse() {
        Vector<Integer> vector = new Vector<>();
        vector.add(10);
        vector.add(20);
        vector.add(30);
        vector.reverse();
        assertEquals(30, vector.get(0), "L'élément à l'index 0 après inversion doit être 30.");
        assertEquals(10, vector.get(2), "L'élément à l'index 2 après inversion doit être 10.");
    }

    @Test
    void testRemoveFirst() {
        Vector<Integer> vector = new Vector<>();
        vector.add(10);
        vector.add(20);
        Integer removed = vector.removeFirst();
        assertEquals(10, removed, "L'élément supprimé en premier doit être 10.");
        assertEquals(1, vector.size(), "La taille doit être 1 après la suppression du premier élément.");
    }

    @Test
    void testRemoveLast() {
        Vector<Integer> vector = new Vector<>();
        vector.add(10);
        vector.add(20);
        Integer removed = vector.removeLast();
        assertEquals(20, removed, "L'élément supprimé en dernier doit être 20.");
        assertEquals(1, vector.size(), "La taille doit être 1 après la suppression du dernier élément.");
    }

    @Test
    void testAddAll() {
        Vector<Integer> vector1 = new Vector<>();
        vector1.add(10);
        vector1.add(20);
        
        Vector<Integer> vector2 = new Vector<>();
        vector2.add(30);
        vector2.add(40);
        
        vector1.addAll(vector2);
        assertEquals(4, vector1.size(), "La taille de vector1 doit être 4 après l'ajout des éléments de vector2.");
        assertEquals(30, vector1.get(2), "Le troisième élément doit être 30.");
        assertEquals(40, vector1.get(3), "Le quatrième élément doit être 40.");
    }

    @Test
    void testSizeRecursive() {
        Vector<Integer> vector = new Vector<>();
        vector.add(10);
        vector.add(20);
        assertEquals(2, vector.sizeRecursive(), "La taille récursive de la liste doit être 2.");
    }
}
