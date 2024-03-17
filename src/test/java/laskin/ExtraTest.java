package laskin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ExtraTest extends AbstractParent {

    private static Laskin laskin = new Laskin();
    private final double DELTA = 0.001;

    @BeforeAll
    public static void testCurrentON() {
        System.out.println("@BeforeAll current ON (Prior to the first test)");
        laskin.currentON();
    }

    @AfterAll
    public static void testCurrentOFF() {
        System.out.println("@AfterAll current OFF (all the tests are done).");
        laskin.currentOFF();
        laskin = null;
    }

    @BeforeEach
    public void testSetZero() {
        System.out.println("  set to zero laskin.");
        laskin.setZero();
        assertEquals(0, laskin.returnResult(), DELTA, "set to zero does not work");
    }

    @Test
    public void testQuadrilateral2() {
        laskin.quadrilateral(2);
        assertEquals(4, laskin.returnResult(), DELTA, "the number 2 Quadrilateral is wrong");
    }

    @Test
    public void testQuadrilateral() {
        laskin.quadrilateral(4);
        assertEquals(16, laskin.returnResult(), DELTA, "the number 4 Quadrilateral is wrong");
    }

    @Test
    public void testQuadrilateral5() {
        laskin.quadrilateral(5);
        assertEquals(25, laskin.returnResult(), DELTA, "the number 5 Quadrilateral is wrong");
    }

    @Test
    public void testSquareroot2() {
        laskin.squareroot(2);
        assertEquals(Math.sqrt(2), laskin.returnResult(), DELTA, "Square root of  2 is wrong");
    }

    @Test
    @DisplayName("test the negative square root")
    public void testNegSquareroot() {
        assertThrows(IllegalArgumentException.class, () -> laskin.squareroot(-2));
    }

    @Test
    public void testDivisionZero() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> laskin.divide(0));
        assertEquals("Cannot divide by zero", exception.getMessage());
    }

}