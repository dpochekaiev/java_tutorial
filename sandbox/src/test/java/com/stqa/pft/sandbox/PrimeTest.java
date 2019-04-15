package com.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrimeTest {

    @Test
    public void testPrimes () {
        Assert.assertFalse(Primes.isPrime(10));
        System.out.println("10 is not prime - OK");
        Assert.assertFalse(Primes.isPrime(9));
        System.out.println("9 is not prime - OK");
        Assert.assertFalse(Primes.isPrime(8));
        System.out.println("8 is not prime - OK");
        Assert.assertTrue(Primes.isPrime(7));
        System.out.println("7 is prime - OK");
        System.out.println();
        Assert.assertFalse(Primes.isPrimeWhile(10));
        System.out.println("10 is not prime - OK");
        Assert.assertFalse(Primes.isPrimeWhile(9));
        System.out.println("9 is not prime - OK");
        Assert.assertFalse(Primes.isPrimeWhile(8));
        System.out.println("8 is not prime - OK");
        Assert.assertTrue(Primes.isPrimeWhile(7));
        System.out.println("7 is prime - OK");
    }

    @Test (enabled = false)
    public void testPrimeLong () {
        long n = Integer.MAX_VALUE;
        Assert.assertTrue(Primes.isPrime(n));
    }

    @Test
    public void testPrimeFast () {
        Assert.assertTrue(Primes.isPrimeFast(Integer.MAX_VALUE));
    }

}
