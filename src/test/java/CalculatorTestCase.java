import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.uem.insw.Calculator;

public class CalculatorTestCase {

    Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }
    
    @Test
    public void testMultiply() {  
        int result = calculator.multiply(2, 3);
        assertEquals(6, result);
    }

    @Test
    public void testConcat() {
        String result = calculator.concat("Hello", "World");
        assertEquals("HelloWorld", result);
    }

    @Test
    public void testSum() {
        double result = calculator.sum(2.5, 3.5);
        assertEquals(6.0, result);
    }

    @Test
    public void testDiscount() {
        double result = calculator.discount(100.0, 20.0);
        assertEquals(80.0, result);
    }

    @Test
    public void testCalculateTotal() {

        List<Double> amounts = new ArrayList<>();
        amounts.add(10.0);
        amounts.add(20.0);
        amounts.add(30.0);
        double result = calculator.calculateTotal(amounts);
        assertEquals(60.0, result);
    }
}