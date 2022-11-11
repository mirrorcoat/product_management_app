package com.mirrorcoat.productapp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.mirrorcoat.productapp.dto.Product;

/**
 * Unit test for Product class
 */
public class ProductTest {
    @Test
    public void testProductGettersAndSetters() {
        Product product = new Product();

        product.setName("milk");
        product.setPrice(3);

        assertEquals("milk", product.getName());
        assertEquals(3, product.getPrice());
    }
}
