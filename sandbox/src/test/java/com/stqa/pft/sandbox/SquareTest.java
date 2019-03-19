package com.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SquareTest {

    @Test
    public void testArea() {
        Square kvadrat = new Square(5);
// 'assert' method is built into java, but gives less info about failures than "Assert.assertEquals()",
// for educational purposes we used non-correct value '24', correct is: '25'
//        assert kvadrat.area() == 24;
        Assert.assertEquals(kvadrat.area(), 25.0);
    }

}
