package com.stqa.pft.sandbox;

public class Primes {

    public static boolean isPrime (int n) {
        for (int i = 2; i < n; i++) {
            if ((n % i) == 0 ) {   //n % i - получить остаток от деления
//            if ((n/i) == Math.round(n/i)) {   //результат от деления целых - тоже ЦЕЛОЕ, поэтому такая проверка всегда возвращает TRUE
                return false;
            }
        }
        return true;
    }

    public static boolean isPrimeFast (int n) {
        int m = (int) Math.sqrt(n); // число m - ближайшее целое (int) к корню из проеряемого. Ведь нет смысла проверять числа больше, чем квадратный корень из проверяемого
        for (int i = 2; i < m; i++) {
            if ((n % i) == 0 ) {   //n % i - получить остаток от деления
                return false;
            }
        }
        return true;
    }

    public static boolean isPrime (long n) {
        for (long i = 2; i < n; i++) {
            if ((n % i) == 0 ) {   //n % i - получить остаток от деления
//            if ((n/i) == Math.round(n/i)) {   //результат от деления целых - тоже ЦЕЛОЕ, поэтому такая проверка всегда возвращает TRUE
                return false;
            }
        }
        return true;
    }

//    public static boolean isPrimeWhile (int n) {
//        int i = 2;
//        while (i < n) {
//            if ((n % i) == 0) {
//                return false;
//            }
//            i++;
//        }
//        return true;
//    }

    public static boolean isPrimeWhile (int n) {
        int i = 2;
        while (i < n && n % i != 0) {
            i++;
        }
        return i == n;
    }

    public static void main(String[] args) {
        System.out.println("Checking FOR- cycle");
        for (int i = -0; i < 22; i++) {
            if (isPrime(i)) {
                System.out.println(i + " is prime - " + isPrime(i));
            } else {
                System.out.println(i);
            }
        }
        System.out.println();
        System.out.println("6/2 = " + 6/2 + "; round(6/2) = " + Math.round(6/2) + " if they equals? " + (6/2 == Math.round(6/2)));
        System.out.println("7/2 = " + 7/2 + "; round(7/2) = " + Math.round(7/2) + " if they equals? " + (7/2 == Math.round(7/2)));
        System.out.println();
        System.out.println("Checking WHILE- cycle");
        int i = 0;
        while (i < 22) {
            if (isPrimeWhile(i)) {
                System.out.println(i + " is prime - " + isPrimeWhile(i));
            } else {
                System.out.println(i);
            }
            i++;
        }

    }

}
