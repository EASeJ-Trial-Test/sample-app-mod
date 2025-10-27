package com.acme.modres.mbean;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for the OpMetadata class.
 */
public class OpMetadataTest {
    
    private static final String TEST_NAME = "testOperation";
    private static final String TEST_DESCRIPTION = "Test operation description";
    private static final String TEST_TYPE = "READ";
    private static final int TEST_IMPACT = 3;
    
    @Test
    public void testDefaultConstructor() {
        // Create a new instance for this test
        OpMetadata opMetadata = new OpMetadata();
        
        // Verify that default constructor initializes fields to null/0
        assertNull(opMetadata.getName());
        assertNull(opMetadata.getDescription());
        assertNull(opMetadata.getType());
        assertEquals(0, opMetadata.getImpact());
    }
    
    @Test
    public void testParameterizedConstructor() {
        // Test the constructor with parameters
        OpMetadata metadata = new OpMetadata(TEST_NAME, TEST_DESCRIPTION, TEST_TYPE, TEST_IMPACT);
        
        assertEquals(TEST_NAME, metadata.getName());
        assertEquals(TEST_DESCRIPTION, metadata.getDescription());
        assertEquals(TEST_TYPE, metadata.getType());
        assertEquals(TEST_IMPACT, metadata.getImpact());
    }
    
    @Test
    public void testSetAndGetName() {
        // Create a new instance for this test
        OpMetadata opMetadata = new OpMetadata();
        
        // Test setter and getter for name
        opMetadata.setName(TEST_NAME);
        assertEquals(TEST_NAME, opMetadata.getName());
        
        // Test with null value
        opMetadata.setName(null);
        assertNull(opMetadata.getName());
    }
    
    @Test
    public void testSetAndGetDescription() {
        // Create a new instance for this test
        OpMetadata opMetadata = new OpMetadata();
        
        // Test setter and getter for description
        opMetadata.setDescription(TEST_DESCRIPTION);
        assertEquals(TEST_DESCRIPTION, opMetadata.getDescription());
        
        // Test with null value
        opMetadata.setDescription(null);
        assertNull(opMetadata.getDescription());
    }
    
    @Test
    public void testSetAndGetType() {
        // Create a new instance for this test
        OpMetadata opMetadata = new OpMetadata();
        
        // Test setter and getter for type
        opMetadata.setType(TEST_TYPE);
        assertEquals(TEST_TYPE, opMetadata.getType());
        
        // Test with null value
        opMetadata.setType(null);
        assertNull(opMetadata.getType());
    }
    
    @Test
    public void testSetAndGetImpact() {
        // Create a new instance for this test
        OpMetadata opMetadata = new OpMetadata();
        
        // Test setter and getter for impact
        opMetadata.setImpact(TEST_IMPACT);
        assertEquals(TEST_IMPACT, opMetadata.getImpact());
        
        // Test with negative value
        opMetadata.setImpact(-1);
        assertEquals(-1, opMetadata.getImpact());
        
        // Test with zero
        opMetadata.setImpact(0);
        assertEquals(0, opMetadata.getImpact());
    }
}

// Made with Bob
