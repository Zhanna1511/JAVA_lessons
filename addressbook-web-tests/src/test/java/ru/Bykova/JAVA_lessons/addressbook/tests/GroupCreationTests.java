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
        Groups before = (Groups) app.group().all();//список ДО равен..
        GroupData group = new GroupData().withName("test2");//созд нов объкт типа групп дэйт с им тест2
        app.group().create(group);
        Groups after = (Groups) app.group().all();//новый список
        assertThat(after.size(), equalTo(before.size() +1));//размер списка после модификации равен размеру списка До+1
        //новой доб.группе присваиваем ИД,где выч-ся максим.значение ИД
        assertThat(after, equalTo(
                before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));//проверялка для сравнения 2хобъектов
    }

}
