package ru.aston;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestFactorial {
    private static Factorial f;

    @BeforeTest
    public static void setUp() {
        f = new Factorial();
    }

    @DataProvider(name="getPositiveNumbers")
    public Object[][] getPositiveNumbers(){
        Object [][] data = new Object [3][2];

        data [0][0] = 2;
        data [0][1] = 2;
        data[1][0] = 3;
        data[1][1] = 6;
        data[2][0] = 10;
        data[2][1] = 3628800;
        return data;
    }

    @Test(dataProvider = "getPositiveNumbers")
    public void testsWithPositiveNumbers(int n, int expected) {
        Assert.assertEquals(expected, f.factorial(n));
    }

    @DataProvider(name="getNegativeNumbers")
    public Object[] getNegativeNumbers() {
        //Object [][] data = new Object [rowCount][colCount];
        Object[] data = new Object[3];

        data[0] = -1;
        data[1] = -2;
        data[2] = -4;
        return data;
    }

    @Test(dataProvider = "getNegativeNumbers")
    public void testsWithNegativeNumbers(int n) {
        Assert.assertThrows(IllegalArgumentException.class, () -> {
           f.factorial(n);
        });
    }

    @Test
    public void testWithZero() {
        Assert.assertEquals(1, f.factorial(0));
    }

    @Test
    public void testWithMaxNumber() {
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            f.factorial(13);
        });
    }
}
