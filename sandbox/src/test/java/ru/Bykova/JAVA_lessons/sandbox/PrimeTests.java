package ru.Bykova.JAVA_lessons.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrimeTests {
    @Test //простое число
    public void TestPrime() {
        Assert.assertTrue(Primes.isPrime(Integer.MAX_VALUE));
    }

    @Test //непростое число
    public void TestNonPrime() {
        long n = Integer.MAX_VALUE-2;
        Assert.assertFalse(Primes.isPrime(n));
    }

    @Test //простое число
    public void TestPrimeLong() {
        Assert.assertTrue(Primes.isPrime(Integer.MAX_VALUE));
    }
}
