package ru.Bykova.JAVA_lessons.addressbook.tests;

import org.testng.annotations.Test;
import ru.Bykova.JAVA_lessons.addressbook.model.GroupData;
import ru.Bykova.JAVA_lessons.addressbook.model.Groups;
import ru.Bykova.JAVA_lessons.addressbook.model.TestBase;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        app.goTo().groupPage();//перейти на стр со списком групп
        Groups before = app.group().all();//список ДО равен..
        GroupData group = new GroupData().withName("test1");//созд нов объкт типа групп дэйт с им тест2
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
