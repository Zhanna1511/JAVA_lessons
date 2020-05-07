package ru.Bykova.JAVA_lessons.sandbox;

public class Equation {
    private double a;
    private double b;
    private double c;

    private int n;

    public Equation(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;

        double d = b*b - 4*a*c;

        if (a == 0) {//непол.форма
            System.out.println("Это вырожденное уравнение");
        }

        if(d>0) { //сокр.форма
            n=2;
        } else if (d == 0) {
            n=1;
        } else {
            n=0;
        }
    }

    public int rootNumber() {
        return n;
    }
}