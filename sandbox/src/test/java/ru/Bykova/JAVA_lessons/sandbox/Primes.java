package ru.Bykova.JAVA_lessons.sandbox;

public class Primes { //если заранее знаем кол-во повторений
    public static boolean isPrime(int n) {//объявили функцию и пишем цикл:
        for (int i = 2; i < n; i = i+1) {
            if (n % i == 0) {//если есть делитель,то:
                return false;

            }
        }//в противном случае:
        return true;
    }
}
