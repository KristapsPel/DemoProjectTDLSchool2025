package multiplyTest;

import calculator.Calculator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class MultiplayTest {
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

    @DataProvider(name = "multiplayTestData")
    public Object [][] createMultiplayTestData (){
        return new Object[][] {
                {2, 3, 6, "Positive number"},
                {-2, -5, 10, "Negative number"},
                {-2, 5, -10, "Positive and Negative number"},
                {2, 0 , 0, "Zero number"}
        };
    }

    @Test(dataProvider = "multiplayTestData",
            testName = "Test for Multiplay methode",
            description = "We test Multiplay methode with different data sets from DataProvider",
    groups = "Regression")
    public void testMultiplay (int a, int b, int expextedResult, String typeTest, Method method) {
        System.out.println(method.getAnnotation(Test.class).description());
        int actualResult = calculator.multiply(a, b);
        Assert.assertEquals(actualResult, expextedResult, "Actual result:"+actualResult+" " +
                "is not the same as expected value:"+expextedResult);
//        if (actualResult == expextedResult ) {
//            System.out.println("Test Multiplay "+typeTest+": Passed");
//        } else {
//            System.out.println("Test Multiplay "+typeTest+": Failed");
//        }
    }
}
