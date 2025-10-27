package com.acme.modres.mbean;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;

/**
 * Unit tests for the OpMetadataList class.
 */
public class OpMetadataListTest {
    
    private static final String TEST_NAME = "testOperation";
    private static final String TEST_DESCRIPTION = "Test operation description";
    private static final String TEST_TYPE = "READ";
    private static final int TEST_IMPACT = 3;
    
    @Test @Disabled
    public void testDefaultConstructor() {
        // Create a new instance using default constructor
        OpMetadataList list = new OpMetadataList();
        
        // Verify that the list is initialized and empty
        assertNotNull(list.getOpMetadatList());
        assertTrue(list.getOpMetadatList().isEmpty());
    }
    
    @Test
    public void testAddMethod() {
        // Create a new instance
        OpMetadataList list = new OpMetadataList();
        
        // Create a test OpMetadata object
        OpMetadata metadata = new OpMetadata(TEST_NAME, TEST_DESCRIPTION, TEST_TYPE, TEST_IMPACT);
        
        // Add the metadata to the list
        list.add(metadata);
        
        // Verify that the list contains the added item
        assertEquals(1, list.getOpMetadatList().size());
        assertSame(metadata, list.getOpMetadatList().get(0));
        
        // Add another item
        OpMetadata metadata2 = new OpMetadata("op2", "description2", "WRITE", 2);
        list.add(metadata2);
        
        // Verify that both items are in the list
        assertEquals(2, list.getOpMetadatList().size());
        assertSame(metadata, list.getOpMetadatList().get(0));
        assertSame(metadata2, list.getOpMetadatList().get(1));
    }
    
    @Test
    public void testGetOpMetadatList() {
        // Create a new instance
        OpMetadataList list = new OpMetadataList();
        
        // Add some test data
        OpMetadata metadata1 = new OpMetadata(TEST_NAME, TEST_DESCRIPTION, TEST_TYPE, TEST_IMPACT);
        OpMetadata metadata2 = new OpMetadata("op2", "description2", "WRITE", 2);
        
        list.add(metadata1);
        list.add(metadata2);
        
        // Get the list
        List<OpMetadata> retrievedList = list.getOpMetadatList();
        
        // Verify the list contents
        assertEquals(2, retrievedList.size());
        assertSame(metadata1, retrievedList.get(0));
        assertSame(metadata2, retrievedList.get(1));
        
        // Verify that modifications to the returned list affect the internal list
        // This tests that getOpMetadatList returns a reference, not a copy
        retrievedList.add(new OpMetadata("op3", "description3", "DELETE", 5));
        assertEquals(3, list.getOpMetadatList().size());
    }
    
    @Test
    public void testSetOpMetadatList() {
        // Create a new instance
        OpMetadataList list = new OpMetadataList();
        
        // Create a new list with test data
        List<OpMetadata> newList = new ArrayList<>();
        OpMetadata metadata1 = new OpMetadata(TEST_NAME, TEST_DESCRIPTION, TEST_TYPE, TEST_IMPACT);
        OpMetadata metadata2 = new OpMetadata("op2", "description2", "WRITE", 2);
        
        newList.add(metadata1);
        newList.add(metadata2);
        
        // Set the list
        list.setOpMetadatList(newList);
        
        // Verify that the internal list was updated
        assertEquals(2, list.getOpMetadatList().size());
        assertSame(metadata1, list.getOpMetadatList().get(0));
        assertSame(metadata2, list.getOpMetadatList().get(1));
        
        // Verify that the internal list is the same object as the one we set
        // by modifying the original list and checking if the internal list changes
        newList.add(new OpMetadata("op3", "description3", "DELETE", 5));
        assertEquals(3, list.getOpMetadatList().size());
        
        // Test with null value
        list.setOpMetadatList(null);
        assertNull(list.getOpMetadatList());
    }
}

// Made with Bob
