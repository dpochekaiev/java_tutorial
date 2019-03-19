package com.stqa.pft.sandbox;

import static java.lang.System.*;

public class PointDistanceEvaluator {

    public static void main (String[] args) {
        Point p1  = new Point(0,0);
        Point p2 = new Point(3,4);

        out.println("The distance between p1 and p2 equals to: " + distance(p1, p2));

    }

    public static double distance (Point p1, Point p2) {
        return Math.sqrt(Math.pow((p1.xCoordinate - p2.xCoordinate), 2) +
                Math.pow((p1.yCoordinate - p2.yCoordinate), 2));
    }

}
