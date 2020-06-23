package ru.Bykova.JAVA_lessons.addressbook.mantis.JAVA_lessons.sandbox;

public class MyFirstProgram {

   public static void main(String[] args) {

       Square s = new Square (5);
       System.out.println("Площадь кв со стороной " + s.l + "=" + s.area());

       Rectangle r = new Rectangle (4, 6);
       System.out.println("Площадь прямоуг со сторонами " + r.a + r.b + "=" + r.area());
   }
}
