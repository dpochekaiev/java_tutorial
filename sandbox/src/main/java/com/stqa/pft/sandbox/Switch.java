package com.stqa.pft.sandbox;

import java.util.Random;

public class Switch {
    public static void main(String[] args) {
        Random random = new Random();
        String[] monthsArray = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        int c = random.nextInt(11);
        String s = monthsArray[c];

        switch (s) {
            case "January":
                System.out.println("This is January, the second winter month");
                break;
            case "February":
                System.out.println("This is February, the last winter month");
                break;
            case "March":
                System.out.println("This is March, the first spring month");
                break;
            case "April":
                System.out.println("This is April, the second winter month");
                break;
            case "September": //  All autumn months are worked out as a single case
            case "October":
            case "November":
                System.out.println("Some AuTuMn stuff :(");
                break;
            default:
                System.out.println("These are OTHER months");
                break;
        }
    }
}
