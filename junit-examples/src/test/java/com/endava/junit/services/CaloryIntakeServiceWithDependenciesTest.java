package com.endava.junit.services;

import com.endava.junit.exceptions.NotificationServiceException;
import com.endava.junit.model.FoodItem;
import mockit.Delegate;
import mockit.Expectations;
import mockit.Mocked;
import mockit.Verifications;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by astoicovici on 9/28/2018.
 */
public class CaloryIntakeServiceWithDependenciesTest {

//    @Mocked
//    private NotificationSender x;

    @Test
    public void addItem_WhenAddingFoodItem_ExpectNotificationSent() {
        // Arrange
        CaloryIntakeServiceWithDependencies service =
                new CaloryIntakeServiceWithDependencies();
        service.setDailyGoal(1000);
        service.setTotal(900);
        FoodItem foodItem = new FoodItem("Ice cream", 250);

        // Act
        service.addItem(foodItem);

        //
    }

    @Test
    public void addItem_WhenAddingFoodItemWithMock_ExpectNotificationSent(
            @Mocked NotificationSender notificationSender) throws NotificationServiceException {
        // Arrange
        CaloryIntakeServiceWithDependencies service =
                new CaloryIntakeServiceWithDependencies();
        service.setDailyGoal(1000);
        service.setTotal(900);
        FoodItem foodItem = new FoodItem("Ice cream", 250);

        new Expectations() {{
            notificationSender.sendNotification(); result = false; minTimes = 0;
            notificationSender.sendNotification((String) any);
                result = new NotificationServiceException("test");
        }};

        // Act
        service.addItem(foodItem);

        //Assert
        new Verifications() {{
            String message;
            notificationSender.sendNotification(); minTimes = 0; maxTimes = 5;
            notificationSender.sendNotification(message=withCapture());
            Assert.assertEquals(message, "Daily goal exceeded");
        }};
    }

    @Test
    public void addItem_WhenAddingFoodItemWithSendNotificationMocked_ExpectNotificationSent(
            @Mocked NotificationSender notificationSender
    ) throws NotificationServiceException {
        // Arrange
        CaloryIntakeServiceWithDependencies service =
                new CaloryIntakeServiceWithDependencies();
        service.setDailyGoal(1000);
        service.setTotal(900);
        FoodItem foodItem = new FoodItem("Ice cream", 250);

        new Expectations() {{
            notificationSender.sendNotification();
                    result = new Delegate() {
                        boolean sendNotification() {
                            System.out.println(
                                    "--- MOCKED sendNotification() ---");
                            return true;
                        }
                    };
        }};

        // Act
        service.addItem(foodItem);

        // Assert
    }

}
