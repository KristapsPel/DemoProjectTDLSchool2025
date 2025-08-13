package calculator;
//1. Create new class Calculator.java in main/java/calculator
//2. In class constructor Initializes the history list to store operation records
//3. Implement the add, subtract, multiply, divide methods that requires two int variables,
// that store operation (Example: 1+1=2) as String variable in history List and return result
//4. Implement method getHistory() that returns list and clearHistory() that clear date from list


import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private List<String> history;

    public Calculator() {
        this.history = new ArrayList<>();
    }

    public int add(int a, int b) {
        int result = a + b;
        history.add(a + "+" + b + "=" + result);
        return result;
    }

    public int subtract(int a, int b) {
        int result = a - b;
        history.add(a + "-" + b + "=" + result);
        return result;
    }

    public int multiply(int a, int b) {
        int result = a * b;
        history.add(a + "*" + b + "=" + result);
        return result;
    }

    public double dived(int a, int b) {
        double result =  (double) a / b;
        history.add(a + "/" + b + "=" + result);
        return result;
    }

    public List<String> getHistory() {
        System.out.println("Return History List");
        return this.history;
    }

    public void clearHistory() {
        System.out.println("Clear List");
        this.history.clear();
    }

}
