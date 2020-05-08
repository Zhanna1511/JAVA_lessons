package ru.Bykova.JAVA_lessons.addressbook.tests;

import org.testng.annotations.Test;
import ru.Bykova.JAVA_lessons.addressbook.model.GroupData;
import ru.Bykova.JAVA_lessons.addressbook.model.TestBase;

public class GroupModificationTests extends TestBase {

    @Test
    public void testGroupModification() {
        app.getNavigationHelper().gotoGroupPage();
        if (! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test1",null,null));
        }
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("test1","test1","test1"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();


    }
}
