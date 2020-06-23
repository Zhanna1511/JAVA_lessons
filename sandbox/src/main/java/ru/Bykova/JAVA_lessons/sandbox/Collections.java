package ru.Bykova.JAVA_lessons.sandbox;

import java.util.ArrayList;
import java.util.List;

public class Collections {

    public static void main(String[] args) {
        String[] langs = {"java","C#","Python","PHP"};
        /*или можно в Неск строк:
        String[] langs = new String[4];//объявлена переменная типа массив строк-в этом массиве будем хранить названия языков прогр.
        langs[0] = "java";//заполн.данными
        langs[1] ="C#";
        langs[2] ="Python";
        langs[3] ="PHP";
         */
        List<String> languages = new ArrayList<String>();
        languages.add("Java");
        languages.add("C#");
        languages.add("Python");
        //или 1стр: List<String> languages = new Arrays.asList("java","C#","Python","PHP");

        for (int i = 0; i < languages.size();i++) {
            System.out.println("Я хочу выучить " + languages.get(i));
        }
        /*либо:
        for (int i=0; i < langs.length; i++) {//прох.по кажд.эл
            System.out.println("Я хочу выучить " + langs[i]);
            }
             */
    }
}