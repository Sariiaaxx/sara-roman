import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
        int resultado = calculator.multiply(2, 3);
        assertEquals(6, resultado);
        int resultado2 = calculator.multiply(0, 5); 
        assertEquals(0, resultado2);
        int resultado3 = calculator.multiply(-2, 3);
        assertEquals(-6, resultado3);
    }

    @Test
    public void testConcat() {
        String resultado = calculator.concat("Hello", "World");
        assertEquals("HelloWorld", resultado);
        String resultado2 = calculator.concat(null, "World");
        assertEquals("empty", resultado2);
    }

    @Test
    public void testSum() {
        double resultado = calculator.sum(2.5, 3.5);
        assertEquals(6.0, resultado);
        double resultado2 = calculator.sum(-2.0, 3.0);
        assertEquals(1.0, resultado2);
    }

    @Test
    public void testDiscount() {
        double resultado = calculator.discount(100.0, 20.0);
        assertEquals(80.0, resultado);
        double resultado2 = calculator.discount(100.0, 0.00);
        assertEquals(100.0, resultado2);
        double resultado3 = calculator.discount(100.0, 100.0);
        assertEquals(0.0, resultado3);
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> calculator.discount(100.0, 150.0));
        assertNotNull(exception);
    }

    @Test
    public void testCalculateTotal() {

        List<Double> amounts = new ArrayList<>();
        amounts.add(10.0);
        amounts.add(20.0);
        amounts.add(30.0);
        double resultado = calculator.calculateTotal(amounts);
        assertEquals(60.0, resultado);

        List<Double> amounts2 = new ArrayList<>();
        double resultado2 = calculator.calculateTotal(amounts2);
        assertEquals(0.0, resultado2);
    }
}