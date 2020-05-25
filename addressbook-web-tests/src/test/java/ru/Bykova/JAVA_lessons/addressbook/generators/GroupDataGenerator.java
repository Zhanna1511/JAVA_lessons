package ru.Bykova.JAVA_lessons.addressbook.generators;

import ru.Bykova.JAVA_lessons.addressbook.model.GroupData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class GroupDataGenerator {

    public static void main(String[] args) throws IOException {//массив пар-ов
        int count = Integer.parseInt(args[0]);//передача данных из ком.строки:1.кол-во групп.
        File file = new File(args[1]);//путь к файлу

        List<GroupData> groups = generateGroups(count);//генерация данных
        save(groups, file);//сохр-е данных в файл
    }

    private static void save(List<GroupData> groups, File file) throws IOException {
        System.out.println(new File(".").getAbsolutePath());
        Writer writer = new FileWriter(file); //откр файл для записи
        for (GroupData group : groups) {//проходимся в цикле по всем группам,кот.нах-ся в списке групс
            writer.write(String.format("%s;%s;%s\n", group.getName(), group.getHeader(), group.getFooter()));
        }
        writer.close();//в конце закрываем файл
    }

    private static List<GroupData> generateGroups(int count) {
        List<GroupData> groups = new ArrayList<GroupData>();
        for (int i = 0; i< count; i++){
            groups.add(new GroupData().withName(String.format("test %s", i))
                    .withHeader(String.format("header %s", i)).withFooter(String.format("footer %s", i)));
        }
        return groups;
    }
}
