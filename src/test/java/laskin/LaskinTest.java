package laskin;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LaskinTest {

    private Laskin laskin = new Laskin();
    private final double DELTA = 0.001;

    @BeforeEach
    public void clearCalculator() {
        laskin.setZero();
    }

    @Test
    public void testAdd() {
        laskin.add(1);
        laskin.add(2);
        assertEquals(3, laskin.returnResult(), DELTA, "Numbers 1 and 2 summation is wrong"); // Muokattu odotettu tulos
    }

    @Test
    public void testSubtract() {
        laskin.add(10);
        laskin.subtract(2);
        assertEquals(8, laskin.returnResult(), DELTA, "Number 10 and 2 difference is wrong"); // Muokattu odotettu tulos
    }

    @Test
    @DisplayName("test the division 8 / 2")
    public void testDivision() {
        laskin.add(8);
        laskin.divide(2);
        assertEquals(4, laskin.returnResult(), DELTA, "division of  8/2 is wrong"); // Muokattu odotettu tulos
    }

    @Test
    @DisplayName("test the division to zero")
    public void testDivisionZero() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> laskin.divide(0));
        assertEquals("Cannot divide by zero", exception.getMessage());
    }
    @Test
    public void testProduct() {
        laskin.setZero();
        laskin.add(2); // Set the initial value to 2
        laskin.product(3); // Multiply by 3
        assertEquals(6, laskin.returnResult(), DELTA, "Product of 2 and 3 is wrong");
    }

    @Test
    @Disabled("this method says it is not yet implements")
    public void testSays() {
       fail("it is not possible to test");
    }
}
