package com.task;

import org.testng.annotations.Test;

public class AmazonAutomationTest {

    //Just to check the automation script works correctly 

    @Test
    public void testShoppingScenario() {
        AmazonAutomation amazonAutomation = new AmazonAutomation();
        amazonAutomation.testAmazonShopping();
    }
}
