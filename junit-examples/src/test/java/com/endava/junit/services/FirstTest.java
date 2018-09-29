package com.endava.junit.services;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Created by astoicovici on 9/27/2018.
 */
public class FirstTest {

//    @Test
//    @Ignore
    public void testIt() {
        // Arrange

        // Act

        // Assert
//        Assert.fail("Unexpected failure.");
        Assert.assertFalse("1 is not equal to 2", 1==2);
    }

    @Test
    public void test_jUnitMatcher_HamcrestMatcher() {
        assertEquals(1, 1); // junit Assert
        assertThat(1, is(equalTo(1))); // hamcrest CoreMatchers

        String expected = "test";
        String actual = "test1";

        assertFalse(expected.equals(actual)); // junit Assert
        assertThat(actual, is(not(equalTo(expected)))); // hamcrest CoreMatchers
    }

}
