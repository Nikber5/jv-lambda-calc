package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char DIVISION = '/';
    private static final char MULTIPLICATION = '*';
    private static final char POWER = '^';
    private static final char ILLEGAL_OPERATION = '$';
    private static final double POSITIVE_VALUE = 12345.678;
    private static final double NEGATIVE_VALUE = -876.543;
    private static final double ZERO = 0;
    private static final double MAX_VALUE = Double.MAX_VALUE;
    private static final double MIN_VALUE = Double.MIN_VALUE;
    private Calculator calculator;
    private double expected;
    private double actual;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void additionWithTwoPositiveOperands_Ok() {
        expected = POSITIVE_VALUE + POSITIVE_VALUE;
        actual = calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, ADDITION);
        assertEquals(expected, actual);
    }

    @Test
    public void additionWithTwoNegativeOperands_Ok() {
        expected = NEGATIVE_VALUE + NEGATIVE_VALUE;
        actual = calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, ADDITION);
        assertEquals(expected, actual);
    }

    @Test
    public void additionWithPositiveAndNegativeOperands_Ok() {
        expected = POSITIVE_VALUE + NEGATIVE_VALUE;
        actual = calculator.calculate(POSITIVE_VALUE, NEGATIVE_VALUE, ADDITION);
        assertEquals(expected, actual);
    }

    @Test
    public void additionWithZeroInDifferentPlaces_Ok() {
        expected = POSITIVE_VALUE + ZERO;
        actual = calculator.calculate(POSITIVE_VALUE, ZERO, ADDITION);
        assertEquals(expected, actual);

        expected = ZERO + POSITIVE_VALUE;
        actual = calculator.calculate(ZERO, POSITIVE_VALUE, ADDITION);
        assertEquals(expected, actual);
    }

    @Test
    public void additionForMinAndMaxDoubleValues_Ok() {
        expected = MAX_VALUE + POSITIVE_VALUE;
        actual = calculator.calculate(MAX_VALUE, POSITIVE_VALUE, ADDITION);
        assertEquals(expected, actual);

        expected = MIN_VALUE + POSITIVE_VALUE;
        actual = calculator.calculate(MIN_VALUE, POSITIVE_VALUE, ADDITION);
        assertEquals(expected, actual);
    }

    @Test
    public void subtractionWithTwoPositiveOperands_Ok() {
        expected = POSITIVE_VALUE - POSITIVE_VALUE;
        actual = calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, SUBTRACTION);
        assertEquals(expected, actual);
    }

    @Test
    public void subtractionWithTwoNegativeOperands_Ok() {
        expected = NEGATIVE_VALUE - NEGATIVE_VALUE;
        actual = calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, SUBTRACTION);
        assertEquals(expected, actual);
    }

    @Test
    public void subtractionWithPositiveAndNegativeOperands_Ok() {
        expected = POSITIVE_VALUE - NEGATIVE_VALUE;
        actual = calculator.calculate(POSITIVE_VALUE, NEGATIVE_VALUE, SUBTRACTION);
        assertEquals(expected, actual);
    }

    @Test
    public void subtractionWithZeroInDifferentPlaces_Ok() {
        expected = ZERO - POSITIVE_VALUE;
        actual = calculator.calculate(ZERO, POSITIVE_VALUE, SUBTRACTION);
        assertEquals(expected, actual);

        expected = POSITIVE_VALUE - ZERO;
        actual = calculator.calculate(POSITIVE_VALUE, ZERO, SUBTRACTION);
        assertEquals(expected, actual);
    }

    @Test
    public void subtractionForMinAndMaxDoubleValues_Ok() {
        expected = MAX_VALUE - POSITIVE_VALUE;
        actual = calculator.calculate(MAX_VALUE, POSITIVE_VALUE, SUBTRACTION);
        assertEquals(expected, actual);

        expected = MIN_VALUE - POSITIVE_VALUE;
        actual = calculator.calculate(MIN_VALUE, POSITIVE_VALUE, SUBTRACTION);
        assertEquals(expected, actual);
    }

    @Test
    public void multiplicationWithTwoPositiveOperands_Ok() {
        expected = POSITIVE_VALUE * POSITIVE_VALUE;
        actual = calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, MULTIPLICATION);
        assertEquals(expected, actual);
    }

    @Test
    public void multiplicationWithTwoNegativeOperands_Ok() {
        expected = NEGATIVE_VALUE * NEGATIVE_VALUE;
        actual = calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, MULTIPLICATION);
        assertEquals(expected, actual);
    }

    @Test
    public void multiplicationWithPositiveAndNegativeOperands_Ok() {
        expected = POSITIVE_VALUE * NEGATIVE_VALUE;
        actual = calculator.calculate(POSITIVE_VALUE, NEGATIVE_VALUE, MULTIPLICATION);
        assertEquals(expected, actual);
    }

    @Test
    public void multiplicationWithZeroInDifferentPlaces_Ok() {
        expected = ZERO * POSITIVE_VALUE;
        actual = calculator.calculate(ZERO, POSITIVE_VALUE, MULTIPLICATION);
        assertEquals(expected, actual);

        expected = POSITIVE_VALUE * ZERO;
        actual = calculator.calculate(POSITIVE_VALUE, ZERO, MULTIPLICATION);
        assertEquals(expected, actual);
    }

    @Test
    public void multiplicationForMinAndMaxDoubleValues_Ok() {
        expected = MAX_VALUE * POSITIVE_VALUE;
        actual = calculator.calculate(MAX_VALUE, POSITIVE_VALUE, MULTIPLICATION);
        assertEquals(expected, actual);

        expected = MIN_VALUE * POSITIVE_VALUE;
        actual = calculator.calculate(MIN_VALUE, POSITIVE_VALUE, MULTIPLICATION);
        assertEquals(expected, actual);
    }

    @Test
    public void divisionWithTwoPositiveOperands_Ok() {
        expected = POSITIVE_VALUE / POSITIVE_VALUE;
        actual = calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, DIVISION);
        assertEquals(expected, actual);
    }

    @Test
    public void divisionWithTwoNegativeOperands_Ok() {
        expected = NEGATIVE_VALUE / NEGATIVE_VALUE;
        actual = calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, DIVISION);
        assertEquals(expected, actual);
    }

    @Test
    public void divisionWithPositiveAndNegativeOperands_Ok() {
        expected = POSITIVE_VALUE / NEGATIVE_VALUE;
        actual = calculator.calculate(POSITIVE_VALUE, NEGATIVE_VALUE, DIVISION);
        assertEquals(expected, actual);
    }

    @Test
    public void divisionWithZeroInFirstPositionPlaces_Ok() {
        expected = ZERO / POSITIVE_VALUE;
        actual = calculator.calculate(ZERO, POSITIVE_VALUE, DIVISION);
        assertEquals(expected, actual);
    }

    @Test
    public void divisionWithZeroInSecondPositionPlaces_notOk() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(POSITIVE_VALUE, ZERO, DIVISION);
        });
    }

    @Test
    public void divisionForMinAndMaxDoubleValues_Ok() {
        expected = MAX_VALUE / POSITIVE_VALUE;
        actual = calculator.calculate(MAX_VALUE, POSITIVE_VALUE, DIVISION);
        assertEquals(expected, actual);

        expected = MIN_VALUE / POSITIVE_VALUE;
        actual = calculator.calculate(MIN_VALUE, POSITIVE_VALUE, DIVISION);
        assertEquals(expected, actual);
    }

    @Test
    public void raisingPositiveAndNegativeValueToThePositivePower_Ok() {
        expected = Math.pow(POSITIVE_VALUE, POSITIVE_VALUE);
        actual = calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, POWER);
        assertEquals(expected, actual);

        expected = Math.pow(NEGATIVE_VALUE, POSITIVE_VALUE);
        actual = calculator.calculate(NEGATIVE_VALUE, POSITIVE_VALUE, POWER);
        assertEquals(expected, actual);
    }

    @Test
    public void raisingPositiveAndNegativeValueToTheNegativePower_Ok() {
        expected = Math.pow(POSITIVE_VALUE, NEGATIVE_VALUE);
        actual = calculator.calculate(POSITIVE_VALUE, NEGATIVE_VALUE, POWER);
        assertEquals(expected, actual);

        expected = Math.pow(NEGATIVE_VALUE, NEGATIVE_VALUE);
        actual = calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, POWER);
        assertEquals(expected, actual);
    }

    @Test
    public void raisingPositiveAndNegativeValueToZeroPower_Ok() {
        expected = Math.pow(POSITIVE_VALUE, ZERO);
        actual = calculator.calculate(POSITIVE_VALUE, ZERO, POWER);
        assertEquals(expected, actual);

        expected = Math.pow(NEGATIVE_VALUE, ZERO);
        actual = calculator.calculate(NEGATIVE_VALUE, ZERO, POWER);
        assertEquals(expected, actual);
    }

    @Test
    public void raisingZeroToPower_Ok() {
        expected = Math.pow(ZERO, POSITIVE_VALUE);
        actual = calculator.calculate(ZERO, POSITIVE_VALUE, POWER);
        assertEquals(expected, actual);

        expected = Math.pow(ZERO, NEGATIVE_VALUE);
        actual = calculator.calculate(ZERO, NEGATIVE_VALUE, POWER);
        assertEquals(expected, actual);
    }

    @Test
    public void illegalOperation_notOk() {
        assertThrows(RuntimeException.class, () -> {
            calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, ILLEGAL_OPERATION);
        });
        assertThrows(RuntimeException.class, () -> {
            calculator.calculate(NEGATIVE_VALUE, POSITIVE_VALUE, ILLEGAL_OPERATION);
        });
        assertThrows(RuntimeException.class, () -> {
            calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, ILLEGAL_OPERATION);
        });
    }
}
