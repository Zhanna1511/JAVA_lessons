package ru.Bykova.JAVA_lessons.addressbook.mantis.JAVA_lessons.sandbox;

//с циклом for
public class Primes { //если заранее знаем кол-во повторений
    public static boolean isPrime(int n) {//объявили функцию и пишем цикл:
        for (int i = 2; i < n; i += 1) {
            if (n % i == 0) {//если есть делитель,то:
                return false;
            }
        }//в противном случае:
        return true;
    }

/*
    //переписали то же самое,но с циклом while
    public static boolean isPrimeWhile(int n) {//исп while
        int i = 2;//переменная,на кот.нужно делить число n
        while (i < n) {//на кажд итер будем перемен.увел.до тех пор,пока не станет =n
            if (n % i == 0) {//если делится,то есть делитель,то:
                return false;
            }
            i++;//если не делится,то увелич.переменную и продолж.цикл дальше
        }//и так до тех пор,пока не вып.усл окончания
        return false;//если дошли до конца цикла ,и ни 1 делителя не найдено,то возвращаем:
    }
}

 */

    public static boolean isPrime(long n) {//объявили функцию и пишем цикл:
        for (long i = 2; i < n; i += 1) {
            if (n % i == 0) {//если есть делитель,то:
                return false;
            }
        }//в противном случае:
        return true;
    }
}
