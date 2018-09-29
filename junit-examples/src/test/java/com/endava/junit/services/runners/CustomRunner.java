package com.endava.junit.services.runners;

import com.endava.junit.services.CaloryIntakeServiceTest;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;

/**
 * Created by astoicovici on 9/28/2018.
 */
public class CustomRunner {

    public static void main(String[] args) {
        JUnitCore jUnitCore = new JUnitCore();
        jUnitCore.addListener(new TextListener(System.out));
        jUnitCore.run(CaloryIntakeServiceTest.class);
    }
}
