package com.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {

    @Test
    public void testDistatnce() {
        Point testPoint1 = new Point(0, 0);
        Point testPoint2 = new Point(3, 4);
        Point testPoint3 = new Point(3, -1.5);
        Point testPoint4 = new Point(-1.25, -1.5);
        Point testPoint5 = new Point (2,3);

        Assert.assertEquals (testPoint1.distance(testPoint2), 5.0);
        Assert.assertEquals (testPoint2.distance(testPoint1), 5.0);
        Assert.assertEquals (roundTo(testPoint2.distance(testPoint5), 4), 1.4142);
        Assert.assertEquals (testPoint2.distance(testPoint3), 5.5);
        Assert.assertEquals (testPoint3.distance(testPoint4), 4.25);
        Assert.assertEquals (roundTo(testPoint4.distance(testPoint1), 4), 1.9526);
        Assert.assertEquals (testPoint4.distance(testPoint2), 6.950719387228922);
    }

    public double roundTo (double valueToRound, int numberOfDecimalPlacesAfterComma) {
        double accuracy = Math.pow(10.0, numberOfDecimalPlacesAfterComma);//10^numberOfDecimalDigits;
        int n = (int) Math.round(valueToRound*accuracy);
        return n/accuracy;
    }

}
