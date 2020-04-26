package ru.Bykova.JAVA_lessons.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SquareTests {

    @Test
    public void testArea() {
        Square s = new Square(5);//созд нов кв
        //s.area(); выч его площ
        //assert s.area() == 25;
        Assert.assertEquals(s.area(),25.0);//для более подробного логирования
    }
}
