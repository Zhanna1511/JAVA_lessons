package ru.Bykova.JAVA_lessons.addressbook.mantis.JAVA_lessons.sandbox;

public class Point {

    public double a;
    public double b;

    public Point(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double distance(Point p2) {
        return Math.sqrt(Math.pow(this.a - p2.a, 2) + Math.pow(this.b - p2.b, 2));
    }
}