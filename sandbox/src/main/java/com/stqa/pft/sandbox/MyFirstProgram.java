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
	}

	public static void hello () {
	    out.println("Hello, world!");
    }

    public static void helloUserName (String userName) {
        out.println("Hello, " + userName + "!");
    }

}