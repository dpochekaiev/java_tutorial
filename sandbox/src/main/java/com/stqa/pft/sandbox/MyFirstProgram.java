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
		double side = 1.5;
		double sideA = 2;
		double sideB = 3;

		out.println("Sqare of " + side + " equals to " + area (side));
		out.println("Area of rectangle with sides " + sideA + " and " + sideB + " equals to "
				+ area (sideA, sideB));
	}

	public static void hello () {
	    out.println("Hello, world!");
    }

    public static void helloUserName (String userName) {
        out.println("Hello, " + userName + "!");
    }

    public static double area (double sideSize) {
		return sideSize * sideSize;
	}

	public static double area (double sideASize, double sideBSize) {
		return sideASize * sideBSize;
	}

}