package tests;

import org.junit.Test;
import junit.framework.*;
import src.calculator.Calculator;

public class CalculatorTest {

    private Calculator  calc = new Calculator();

    @Test
    public void addTest()
    {
        calc.compute(1,1,"+");
        Assert.assertEquals(2,calc.getResult());
        calc.cleanResult();
        calc.compute(31,142,"+");
        Assert.assertEquals(173,calc.getResult());
        calc.cleanResult();
    }

    @Test
    public void substractTest()
    {
        calc.compute(10,9,"-");
        Assert.assertEquals(1,calc.getResult());
    }

    @Test
    public void multiplyTest()
    {
        calc.compute(1000,1000,"*");
        Assert.assertEquals(1000000,calc.getResult());
    }

    @Test
    public void divideTest()
    {
        calc.compute(100,4,"/");
        Assert.assertEquals(25,calc.getResult());
    }

    @Test
    public void powTest()
    {
        calc.compute(10,2,"^");
        Assert.assertEquals(100,calc.getResult());
    }


}
