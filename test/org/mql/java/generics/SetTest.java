package org.mql.java.generics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class SetTest {
    private Set<String> set;

    @BeforeEach
    public void setUp() {
        set = new Set<>();
    }

    @Test
    public void testAdd() {
        assertTrue(set.add("A"), "Should add element A");
        assertTrue(set.add("B"), "Should add element B");
        assertFalse(set.add("A"), "Should not add duplicate element A");
        assertEquals(2, set.size(), "Size should be 2 after adding A and B");
    }

    @Test
    public void testRemove() {
        set.add("A");
        set.add("B");
        assertTrue(set.remove("A"), "Should remove element A");
        assertFalse(set.remove("A"), "Should not remove non-existing element A");
        assertEquals(1, set.size(), "Size should be 1 after removing A");
    }

    @Test
    public void testContains() {
        set.add("A");
        assertTrue(set.contains("A"), "Set should contain element A");
        assertFalse(set.contains("B"), "Set should not contain element B");
    }

    @Test
    public void testIsEmpty() {
        assertTrue(set.isEmpty(), "Set should be empty initially");
        set.add("A");
        assertFalse(set.isEmpty(), "Set should not be empty after adding an element");
    }

    @Test
    public void testClear() {
        set.add("A");
        set.add("B");
        set.clear();
        assertTrue(set.isEmpty(), "Set should be empty after clear");
    }

    @Test
    public void testSize() {
        assertEquals(0, set.size(), "Initial size should be 0");
        set.add("A");
        assertEquals(1, set.size(), "Size should be 1 after adding one element");
        set.add("B");
        assertEquals(2, set.size(), "Size should be 2 after adding two elements");
    }

    @Test
    public void testToArray() {
        set.add("A");
        set.add("B");
        Object[] expectedArray = {"A", "B"};
        assertArrayEquals(expectedArray, set.toArray(), "toArray should return the correct array representation of the Set");
    }

    @Test
    public void testAddAll() {
        Collection<String> collection = Arrays.asList("C", "D", "E");
        assertTrue(set.addAll(collection), "Should add all elements from the collection");
        assertTrue(set.contains("C"), "Set should contain C after addAll");
        assertEquals(3, set.size(), "Size should be 3 after adding C, D, E");

        // Test adding duplicates
    }

    @Test
    public void testRemoveAll() {
        set.add("A");
        set.add("B");
        
        Collection<String> collection = Arrays.asList("A", "C"); // Contains A which is in the Set
        assertTrue(set.removeAll(collection), "Should remove elements that are in the collection");

        // Check the size and contents of the Set
        assertFalse(set.contains("A"), "Set should not contain A after removal");
        assertEquals(1, set.size(), "Size should be 1 after removing A");

        // Check removing non-existing elements
        Collection<String> nonExisting = Arrays.asList("C", "D"); 
        assertFalse(set.removeAll(nonExisting), "Should not modify the Set when removing non-existing elements"); 
    }
}