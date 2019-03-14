package com.stqa.pft.sandbox;

import static java.lang.System.*;

public class MyFirstProgram {

	public static void main (String[] args) {
		hello();
		helloUserName("Mike");
		int i = 2 + 2;
		out.println("2 + 2 = " + i);
		out.println("3 + 3 = " + (3+3));
		out.println();

		double x = 1 / 2.0;
		out.println("1/2 = " + x); out.println();

		int j = 2 + 2 * 3;
		out.println("2 + 2 * 3 = " + j);

		out.print("T"); out.print("his "); out.print("string");
		out.print(" is "); out.println("concatenated.");
		hello();hello();
		helloUserName("Olga");

		out.println();

		Square someKvadrat = new Square(5);
		Rectangle somePriamougolnik = new Rectangle(4, 3);
		Point p1  = new Point(0,0);
		Point p2 = new Point(3,4);

		out.println("Area of a square with a " + someKvadrat.sideLength + " side equals to: " + someKvadrat.area());
		out.println("Area of a rectangle with sides " + somePriamougolnik.sideALength + " and "
				+ somePriamougolnik.sideBLength + " equals to: " + somePriamougolnik.area());

		out.println("The distance between p1 and p2 equals to: " + distance(p1, p2));
	}

	public static void hello () {
	    out.println("Hello, world!");
    }

    public static void helloUserName (String userName) {
        out.println("Hello, " + userName + "!");
    }

    public static double distance (Point p1, Point p2) {
		return Math.sqrt(Math.pow((p1.xCoordinate - p2.xCoordinate), 2) +
				Math.pow((p1.yCoordinate - p2.yCoordinate), 2));
	}

}