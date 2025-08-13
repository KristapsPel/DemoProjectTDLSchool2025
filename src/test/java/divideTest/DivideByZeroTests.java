package divideTest;

import calculator.Calculator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DivideByZeroTests {
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

    @Test(expectedExceptions = ArithmeticException.class,
    groups = {"Regression"})
    public void testDivisionByZeroWithExpectedException () {
        calculator.dived(10, 0);
    }

    @Test(groups = {"Regression"})
    public void testDivisionByZeroWithoutExpectedException () {
        calculator.dived(10, 0);
    }
}
