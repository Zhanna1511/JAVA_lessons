package ru.Bykova.JAVA_lessons.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.Bykova.JAVA_lessons.addressbook.model.GroupData;
import ru.Bykova.JAVA_lessons.addressbook.model.TestBase;
import ru.Bykova.JAVA_lessons.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().GroupPage();//переход на нужную стр.
    if (app.db().groups().size() == 0) {//проверка предусловия, и если оно не вып.-подготовка состояния
      app.group().create(new GroupData().withName("test1"));//созд нов объект типа групп дэйт с им тест1
    }
  }

  @Test
  public void testGroupDeletion() throws Exception {
    Groups before = app.db().groups();
    GroupData deletedGroup = before.iterator().next();
    app.group().delete(deletedGroup);
    assertThat(app.group().count(), equalTo(before.size() - 1));//проверка должна стоять перед загрузкой списка групп
    Groups after = app.db().groups();
    assertThat(after, equalTo(before.without(deletedGroup)));
  }
}
