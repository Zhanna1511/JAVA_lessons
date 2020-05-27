package ru.Bykova.JAVA_lessons.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.Bykova.JAVA_lessons.addressbook.model.GroupData;
import ru.Bykova.JAVA_lessons.addressbook.model.Groups;
import ru.Bykova.JAVA_lessons.addressbook.model.TestBase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validGroups() {//провайдер тестовых данных
       List<Object[]> list = new ArrayList<Object[]>();//заполн список массивов
       list.add(new Object[] {new GroupData().withName("test1").withHeader("header 1").withFooter("footer 1")});//кажд массив содержит набор данных для 1 запуска тестового метода-сколько будет таких наборов в списке-столько раз запуститься тестовый метод
       list.add(new Object[] {new GroupData().withName("test2").withHeader("header 2").withFooter("footer 2")});
       list.add(new Object[] {new GroupData().withName("test3").withHeader("header 3").withFooter("footer 3")});
       return list.iterator();
    }


    @Test(dataProvider = "validGroups")
    public void testGroupCreation(GroupData group) {
        app.goTo().groupPage();//перейти на стр со списком групп
        Groups before = app.group().all();//список ДО равен..
        app.group().create(group);
        assertThat(app.group().count(), equalTo(before.size() + 1));
        Groups after = app.group().all();//новый список
        assertThat(after, equalTo(
                before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));//проверялка для сравнения 2хобъектов
    }

    @Test
    public void testBadGroupCreation() throws Exception {//пример негативного теста
        app.goTo().groupPage();
        Groups before = app.group().all();
        GroupData group = new GroupData().withName("test1'");
        app.group().create(group);
        assertThat(app.group().count(), equalTo(before.size()));//проверка должна стоять перед загрузкой списка групп
        Groups after = app.group().all();
        assertThat(after, equalTo(before));
    }

}
