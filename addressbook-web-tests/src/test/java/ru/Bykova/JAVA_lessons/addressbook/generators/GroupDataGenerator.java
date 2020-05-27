package ru.Bykova.JAVA_lessons.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import ru.Bykova.JAVA_lessons.addressbook.model.GroupData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class GroupDataGenerator {

    @Parameter(names ="-c", description = "Group count")
    public int count;

    @Parameter(names ="-f", description = "Target file")
    public String file;

    @Parameter(names ="-d", description = "Data format")//для формата xml
    public String format;

    public static void main(String[] args) throws IOException {//массив пар-ов
        GroupDataGenerator generator = new GroupDataGenerator();
        JCommander jCommander = new JCommander(generator);
        try {
            jCommander.parse(args);
        } catch (ParameterException ex) {
            jCommander.usage();
            return;
        }
        generator.run();
    }

    private void run() throws IOException {
        List<GroupData> groups = generateGroups(count);//генерация данных
        if (format.equals("csv")){//проверка для формата
            saveAsCsv(groups, new File(file));//сохр-е данных в файл
        } else if (format.equals("xml")){
            saveAsXml(groups, new File(file));
        } else if (format.equals("json")){
            saveAsJson(groups, new File(file));
        } else {
            System.out.println("Unrecognized format " + format);

        }
    }

    private void saveAsJson(List<GroupData> groups, File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();//должен красиво выводить данные и пропускать поля,кот не надо реализовывать
        String json = gson.toJson(groups);
        Writer writer = new FileWriter(file);
        writer.write(json);
        writer.close();
    }

    private void saveAsXml(List<GroupData> groups, File file) throws IOException {
        XStream xstream = new XStream();//список групп,который нужно сохранять
        xstream.processAnnotations(GroupData.class);//чтобы в файле xml вместо длинного адреса был тег
        String xml = xstream.toXML(groups);//файл,в кот.нужно сохранять
        Writer writer = new FileWriter(file);
        writer.write(xml);
        writer.close();
    }

    private void saveAsCsv(List<GroupData> groups, File file) throws IOException {
        System.out.println(new File(".").getAbsolutePath());
        Writer writer = new FileWriter(file); //откр файл для записи
        for (GroupData group : groups) {//проходимся в цикле по всем группам,кот.нах-ся в списке групс
            writer.write(String.format("%s;%s;%s\n", group.getName(), group.getHeader(), group.getFooter()));
        }
        writer.close();//в конце закрываем файл
    }

    private List<GroupData> generateGroups(int count) {
        List<GroupData> groups = new ArrayList<GroupData>();
        for (int i = 0; i< count; i++){
            groups.add(new GroupData().withName(String.format("test %s", i))
                    .withHeader(String.format("header %s", i)).withFooter(String.format("footer %s", i)));
        }
        return groups;
    }
}
