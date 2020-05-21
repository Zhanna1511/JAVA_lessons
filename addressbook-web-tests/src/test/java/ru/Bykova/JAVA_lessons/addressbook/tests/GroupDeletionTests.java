package ru.Bykova.JAVA_lessons.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.Bykova.JAVA_lessons.addressbook.model.GroupData;
import ru.Bykova.JAVA_lessons.addressbook.model.TestBase;

import java.util.Set;

public class GroupDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();//переход на нужную стр.
    if (app.group().all().size() == 0) {//проверка предусловия, и если оно не вып.-подготовка состояния
      app.group().create(new GroupData().withName("test1"));//созд нов объект типа групп дэйт с им тест1
    }
  }

  @Test
  public void testGroupDeletion() throws Exception {
    Set<GroupData> before = app.group().all();
    GroupData deletedGroup = before.iterator().next();
    app.group().delete(deletedGroup);
    Set<GroupData> after = app.group().all();
    Assert.assertEquals(after.size(), before.size() -1);

    before.remove(deletedGroup);
    Assert.assertEquals(before, after);
  }
}
