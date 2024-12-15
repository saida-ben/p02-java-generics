package org.mql.java.generics;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LinkedListTest {

    @Test
    void testAddAndSize() {
        List<Integer> l1 = new LinkedList<Integer>();  // Créer une nouvelle liste de type LinkedList qui peut contenir des éléments de type Integer
        l1.add(20);
        l1.add(150);
        l1.add(74);
        assertEquals(3, l1.size());  // Vérifie que la taille est de 3
    }

    @Test
    void testSize() {
        List<Integer> l1 = new LinkedList<Integer>();  // Créer une nouvelle liste vide
        assertEquals(0, l1.size());  // Vérifie que la taille est initialement 0
    }

    @Test
    void testGetNull() {
        List<Integer> l1 = new LinkedList<Integer>();  // Créer une nouvelle liste vide
        assertNull(l1.get(0));  // Vérifie que la récupération d'un élément à un index invalide renvoie null
    }

    @Test
    void testGet() {
        List<Integer> l1 = new LinkedList<Integer>();  // Créer une nouvelle liste
        l1.add(20);
        l1.add(150);
        l1.add(74);
        assertAll(
                () -> assertEquals(20, l1.get(0)),  // Vérifie que le premier élément est 20
                () -> assertEquals(74, l1.get(2)),  // Vérifie que le dernier élément est 74
                () -> assertNull(l1.get(3))  // Vérifie que l'index 3 est invalide et renvoie null
        );
    }

    @Test
    void testRemove() {
        List<Integer> l1 = new LinkedList<Integer>();  // Créer une nouvelle liste
        l1.add(20);
        l1.add(150);
        l1.add(74);
        int removed = l1.remove(0);  // Retirer l'élément à l'index 0
        assertAll(
                () -> assertEquals(20, removed),  // Vérifie que l'élément retiré est bien 20
                () -> assertEquals(2, l1.size())  // Vérifie que la taille de la liste est maintenant 2
        );
    }

    @Test
    void testRemoveInvalidIndex() {
        List<Integer> l1 = new LinkedList<Integer>();  // Créer une nouvelle liste
        l1.add(20);
        l1.add(150);
        assertThrows(IndexOutOfBoundsException.class, () -> l1.remove(1));  // Vérifie qu'une exception est levée si l'index est invalide
    }

    @Test
    void testSet() {
        List<Integer> l1 = new LinkedList<Integer>();  // Créer une nouvelle liste
        l1.add(20);
        l1.add(150);
        l1.set(1, 74);  // Modifier l'élément à l'index 1
        assertEquals(74, l1.get(1));  // Vérifie que l'élément à l'index 1 a été modifié
    }


    @Test
    void testClear() {
        List<Integer> l1 = new LinkedList<Integer>();  // Créer une nouvelle liste
        l1.add(20);
        l1.add(150);
        l1.clear();  // Vider la liste
        assertEquals(0, l1.size());  // Vérifie que la taille est 0 après avoir vidé la liste
    }

    @Test
    void testIsEmpty() {
        List<Integer> l1 = new LinkedList<Integer>();  // Créer une nouvelle liste vide
        assertTrue(l1.isEmpty());  // Vérifie que la liste est vide
        l1.add(20);
        assertFalse(l1.isEmpty());  // Vérifie que la liste n'est pas vide après ajout d'un élément
    }

    @Test
    void testContains() {
        List<Integer> l1 = new LinkedList<Integer>();  // Créer une nouvelle liste
        l1.add(20);
        l1.add(150);
        assertTrue(l1.contains(150));  // Vérifie que l'élément 150 est dans la liste
        assertFalse(l1.contains(100));  // Vérifie que l'élément 100 n'est pas dans la liste
    }

    @Test
    void testIndexOf() {
        List<Integer> l1 = new LinkedList<Integer>();  // Créer une nouvelle liste
        l1.add(20);
        l1.add(150);
        l1.add(74);
        assertEquals(1, l1.indexOf(150));  // Vérifie que l'index de l'élément 150 est 1
        assertEquals(-1, l1.indexOf(100));  // Vérifie que l'index d'un élément inexistant est -1
    }

    @Test
    void testReverse() {
        List<Integer> l1 = new LinkedList<Integer>();  // Créer une nouvelle liste
        l1.add(20);
        l1.add(150);
        l1.add(74);
        l1.reverse();  // Inverser la liste
        assertEquals(150, l1.get(0));  // Vérifie que le premier élément est maintenant 74
        assertEquals(74, l1.get(1));  // Vérifie que le deuxième élément est maintenant 150
    }

    @Test
    void testToArray() {
        List<Integer> l1 = new LinkedList<Integer>();  // Créer une nouvelle liste
        l1.add(20);
        l1.add(150);
        Object[] array = l1.toArray();  // Convertir la liste en tableau
        assertEquals(2, array.length);  // Vérifie que la longueur du tableau est 2
        assertEquals(20, array[0]);  // Vérifie que le premier élément est 20
    }

    @Test
    void testSizeRecursive() {
        List<Integer> l1 = new LinkedList<Integer>();  // Créer une nouvelle liste
        l1.add(20);
        l1.add(150);
        assertEquals(2, l1.sizeRecursive());  // Vérifie que la taille récursive est correcte
    }

    @Test
    void testAddAll() {
        List<Integer> l1 = new LinkedList<Integer>();  // Créer une nouvelle liste
        l1.add(20);
        l1.add(150);
        List<Integer> l2 = new LinkedList<Integer>();  // Créer une autre liste
        l2.add(74);
        l2.add(100);
        l1.addAll(l2);  // Ajouter tous les éléments de l2 à l1
        assertEquals(4, l1.size());  // Vérifie que la taille de l1 est maintenant 4
        assertEquals(74, l1.get(2));  // Vérifie que le troisième élément est 74
    }
}
