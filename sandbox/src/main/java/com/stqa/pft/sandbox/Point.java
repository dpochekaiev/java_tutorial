package com.stqa.pft.sandbox;

public class Point {

    public double xCoordinate;
    public double yCoordinate;

    public Point (double xCoordinate, double yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public double distance (Point p2) {
        return Math.sqrt(Math.pow((this.xCoordinate - p2.xCoordinate), 2) +
                Math.pow((this.yCoordinate - p2.yCoordinate), 2));
    }

}
