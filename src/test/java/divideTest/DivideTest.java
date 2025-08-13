package divideTest;

import calculator.Calculator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DivideTest {
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

    @DataProvider(name = "divideTestData")
    public Object [][] createDivideTestData (){
        return new Object[][] {
                {6, 3, 2, "Positive number"},
                {5, 2, 2.5, "Negative number "},
                {5, 5, 1, "Positive number"},
                {5, -1 , -5, "Negative numbers"}
        };
    }

    @Test(dataProvider = "divideTestData",
            testName = "Test for Divide methode",
            description = "We test Divide methode with different data sets from DataProvider",
    groups = {"Regression", "Smoke"})
    public void testAdd (int a, int b, double expextedResult, String typeTest, Method method) {
        System.out.println(method.getAnnotation(Test.class).description());
        double actualResult = calculator.dived(a, b);
        Assert.assertEquals(actualResult, expextedResult, "Actual result:"+actualResult+" " +
                "is not the same as expected value:"+expextedResult);
//        if (actualResult == expextedResult ) {
//            System.out.println("Test Divide "+typeTest+": Passed");
//        } else {
//            System.out.println("Test Divide "+typeTest+": Failed");
//        }
    }
}
