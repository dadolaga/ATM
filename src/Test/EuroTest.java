package Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Code.Business_logic.Euro;

public class EuroTest {
    @Test
    public void testGetPositiveValueSingleParameterCostructor() {
        var euro = new Euro(52);
        assertEquals(5200, euro.getValore());
    }

    @Test
    public void testGetNegativeValueSingleParameterCostructor() {
        var euro = new Euro(-22);
        assertEquals(-2200, euro.getValore());
    }

    @Test
    public void testGetPositiveDecimalValueSingleParameterCostructor() {
        var euro = new Euro(-2.21);
        assertEquals(-221, euro.getValore());
    }

    @Test
    public void testGetPositiveDeciamllValueDoubleParameterCostructor() {
        var euro = new Euro(36, 24);
        assertEquals(3624, euro.getValore());
    }

    @Test
    public void testGetNegativeDeciamlValueDoubleParameterCostructor() {
        var euro = new Euro(-36, 20);
        assertEquals(-3620, euro.getValore());
    }

    @Test
    public void testLessThen() {
        var minValue = new Euro(2.54);
        var greaterValue = new Euro(54.23);

        assertTrue(minValue.minoreDi(greaterValue));
    }

    @Test
    public void testEqualThenWithFunctionMinoreDi() {
        var minValue = new Euro(2.54);
        var greaterValue = new Euro(2.54);

        assertTrue(minValue.minoreDi(greaterValue));
    }

    @Test
    public void testGretherThen() {
        var minValue = new Euro(2.54);
        var greaterValue = new Euro(54.23);

        assertTrue(!greaterValue.minoreDi(minValue));
    }

    @Test
    public void testSum() {
        var euro1 = new Euro(52.32);
        var euro2 = new Euro(-36.14);

        // I use .getValore because .equals in object is not override in Euro class
        assertEquals(1618, euro1.somma(euro2).getValore());
    }

    @Test
    public void testSub() {
        var euro1 = new Euro(52.32);
        var euro2 = new Euro(-36.14);

        // I use .getValore because .equals in object is not override in Euro class
        assertEquals(8846, euro1.sottrai(euro2).getValore());
    }

    @Test
    public void testPrintPositiveNumber() {
        var euro = new Euro(35.78);

        assertEquals("35.78 euro", euro.stampa());
    }

    @Test
    public void testPrintNegativeNumber() {
        var euro = new Euro(-6.45);

        assertEquals("-6.45 euro", euro.stampa());
    }

    @Test
    public void testEqual() {
        var euro1 = new Euro(52.32);
        var euro2 = new Euro(52.32);

        assertTrue(euro1.ugualeA(euro2));
    }

    @Test
    public void testEqualWhenValueNotEqual() {
        var euro1 = new Euro(52.32);
        var euro2 = new Euro(-33.32);

        assertTrue(!euro1.ugualeA(euro2));
    }
}
