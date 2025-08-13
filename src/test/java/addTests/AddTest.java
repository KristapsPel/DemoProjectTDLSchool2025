package addTests;

import calculator.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.reflect.Method;

//Create dataProviderMethod with @DataProvider annotation that returns Object[][]
//Provide 3 variable (a, b and expected result) add all values from previous created tests
//Add dataProvider data to test
//Use data from dataProvider in test
//Add testName and description
//Print in terminal testDescription
//Run the same 4 tests that we did run on previous practical task using just one test method
//Test Commit


public class AddTest {

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

    @DataProvider(name = "addTestData")
    public Object[][] createAddTestData() {
        return new Object[][]{
                {2, 3, 5, "Positive number"},
                {-2, -5, 7, "Negative number"},
                {-2, 5, 3, "Positive and Negative number"},
                {2, 0, 2, "Zero number"}
        };
    }

    @Test(dataProvider = "addTestData",
            testName = "Test for Add methode",
            description = "We test Add methode with different data sets from DataProvider",
            groups = {"Regression", "Smoke"})
    public void testAdd(int a, int b, int expextedResult, String typeTest, Method method) {
        System.out.println(method.getAnnotation(Test.class).description());
        int actualResult = calculator.add(a, b);
        Assert.assertEquals(actualResult, expextedResult, "Actual result:"+actualResult+" " +
                "is not the same as expected value:"+expextedResult);
//        if (actualResult == expextedResult) {
//            System.out.println("Test Add " + typeTest + ": Passed");
//        } else {
//            System.out.println("Test Add " + typeTest + ": Failed");
//        }
    }
}
