package com.endava.junit.services;

import com.endava.junit.exceptions.NegativeCaloryException;
import com.endava.junit.model.FoodItem;
import com.endava.junit.services.categories.LongRunningCategory;
import com.endava.junit.services.categories.SmokeCategory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

/**
 * Created by astoicovici on 9/28/2018.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CaloryIntakeServiceTest {

    private CaloryIntakeService service;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @BeforeClass
    public static void setUpForAll() {
        System.out.println("--- BEFORE CLASS ---");
    }

    @AfterClass
    public static void tearDownAfterAll() {
        System.out.println(("--- AFTER CLASS ---"));
    }

    @Before
    public void setUp() {
        service = new CaloryIntakeService();
        System.out.println("-- BEFORE ---");
    }

    @After
    public void tearDown() {
        System.out.println("--- AFTER ---");
    }

    @Test
    @Category({SmokeCategory.class, LongRunningCategory.class})
    public void setDailyGoal_WhenSetting1000_ExpectDailyGoalSet() throws NegativeCaloryException {
        // Arrange


        // Act
        service.setDailyGoal(1000);

        // Assert
        assertEquals("Daily goal is not 1000", 1000, service.getDailyGoal());
        assertTrue(1000 == service.getDailyGoal());
    }

    @Test(expected = NegativeCaloryException.class)
    public void setDailyGoal_WhenSettingNegativeValue_ExpectZero() throws NegativeCaloryException {
        service.setDailyGoal(-450);
//        assertTrue(serviceUnderTest.getDailyGoal() == 0);

    }

    @Test
    @Category(LongRunningCategory.class)
    public void setDailyGoal_WhenSettingNegativeValue_ExpectException() throws NegativeCaloryException {
        // Arrange
        thrown.expect(NegativeCaloryException.class);
        thrown.expectMessage("Daily goal attempt to set as negative.");

        // Act
        service.setDailyGoal(-450);

        // Assert

    }

    @Test
    public void addItem_WhenAddingFoodItem_ExpectTotalIncreased() throws NegativeCaloryException {
        // Arrange
        service.setTotal(600);
        service.setDailyGoal(1500);
        FoodItem newFoodItem = new FoodItem("Shaorma", 1000);

        // Act
        service.addItem(newFoodItem);

        // Assert
        int total = service.getTotal();
        Assert.assertTrue("Total was not increased after adding food item.",
                total == 1600);
        Assert.assertTrue("Item was not added",
                service.containsItem(newFoodItem));
    }

    @Test(timeout = 10)
    @Ignore
    public void reallyLongTest() {
        for (int i = 0; i < 10000000; i++) {

        }
    }

}
