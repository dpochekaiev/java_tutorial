package com.stqa.pft.sandbox;

import static java.lang.System.*;

public class PointDistanceEvaluatorProgram {

    public static void main (String[] args) {
        Point p1 = new Point(0,0);
        Point p2 = new Point(3,4);
        Point p3 = new Point(1,1);

        out.println("The distance between p1 and p2 equals to: " + p1.distance(p2));
        out.println("The distance between p2 and p1 equals to: " + p2.distance(p1));
        out.println("The distance between p1 and p1 equals to: " + p1.distance(p1));
        out.println("The distance between p3 and p1 equals to: " + p3.distance(p1));

    }

}
