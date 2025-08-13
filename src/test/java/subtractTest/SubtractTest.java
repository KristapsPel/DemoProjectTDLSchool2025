package subtractTest;

import calculator.Calculator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class SubtractTest {
    Calculator calculator = new Calculator();

    @BeforeMethod
    public void setUp(){
        Assert.assertTrue(calculator.getHistory().isEmpty(), "History list is not empty. " +
                "Size:"+calculator.getHistory().size());
    }

    @AfterMethod
    public void tearDow () {
        calculator.clearHistory();
    }

    @DataProvider(name = "subtractTestData")
    public Object [][] createAddTestData (){
        return new Object[][] {
                {2, 3, -1, "Positive number"},
                {-2, -5, 3, "Negative number"},
                {-2, 5, -7, "Positive and Negative number"},
                {2, 0 , 2, "Zero number"}
        };
    }

    @Test(dataProvider = "subtractTestData",
            testName = "Test for Subtract methode",
            description = "We test Subtract methode with different data sets from DataProvider",
    groups = "Regression")
    public void testSubtract (int a, int b, int expextedResult, String typeTest, Method method) {
        System.out.println(method.getAnnotation(Test.class).description());
        int actualResult = calculator.subtract(a, b);
        Assert.assertEquals(actualResult, expextedResult, "Actual result:"+actualResult+" " +
                "is not the same as expected value:"+expextedResult);
//        if (actualResult == expextedResult ) {
//            System.out.println("Test Subtract "+typeTest+": Passed");
//        } else {
//            System.out.println("Test Subtract "+typeTest+": Failed");
//        }
    }
}
