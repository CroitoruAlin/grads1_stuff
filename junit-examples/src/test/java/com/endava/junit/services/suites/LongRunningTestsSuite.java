package com.endava.junit.services.suites;

import com.endava.junit.services.CaloryIntakeServiceTest;
import com.endava.junit.services.FirstTest;
import com.endava.junit.services.categories.LongRunningCategory;
import com.endava.junit.services.categories.SmokeCategory;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by astoicovici on 9/28/2018.
 */
@RunWith(Categories.class)
//@Categories.ExcludeCategory(SmokeCategory.class)
@Categories.IncludeCategory(LongRunningCategory.class)
@Suite.SuiteClasses(
        {CaloryIntakeServiceTest.class,
                FirstTest.class})
public class LongRunningTestsSuite {
}
