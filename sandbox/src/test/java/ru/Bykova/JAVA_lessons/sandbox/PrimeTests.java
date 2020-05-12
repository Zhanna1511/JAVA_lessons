package ru.Bykova.JAVA_lessons.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrimeTests {
    @Test //простое число
    public void TestPrimes() {
        Assert.assertTrue(Primes.isPrime(Integer.MAX_VALUE));
    }

    @Test //непростое число
    public void TestNonPrimes() {
        Assert.assertFalse(Primes.isPrime(Integer.MAX_VALUE-2));
    }
}
