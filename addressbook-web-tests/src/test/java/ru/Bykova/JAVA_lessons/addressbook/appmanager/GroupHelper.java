package ru.Bykova.JAVA_lessons.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.Bykova.JAVA_lessons.addressbook.model.GroupData;
import ru.Bykova.JAVA_lessons.addressbook.model.Groups;

import java.util.List;

public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void deleteSelectedGroups() {
        click(By.name("delete"));
    }

    public void selectGroupById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public void initGroupModification() {
        click (By.name("edit"));
    }

    public void submitGroupModification() {
        click (By.name("update"));
    }

    public void create(GroupData group) {
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        groupCache = null;//сбросить кеширование,если группа удалена
        returnToGroupPage();
    }

    public void modify(GroupData group) {
        selectGroupById(group.getId());//выбр.гр.
        initGroupModification();//нач.модификацию
        fillGroupForm(group);//заполн.форму
        submitGroupModification();//подтвердить
        groupCache = null;//сбросить кеширование,если группа удалена
        returnToGroupPage();//вернуться на гл.стр.
    }

    public void delete(GroupData group) {
        selectGroupById(group.getId());
        deleteSelectedGroups();
        groupCache = null;//сбросить кеширование,если группа удалена
        returnToGroupPage();
    }

    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }

    private Groups groupCache = null; //кеширование

    public Groups all() {//всп метод,кот.возвр.не список ,а мн-во
        if (groupCache != null) { //если кеш не пустой,то его и нужно вернуть
           return new Groups (groupCache);//лучше возвращать не сам кеш,а его копию
        }
        groupCache = new Groups();//если не заполнен,то придется инициализировать,заполнить и вернуть его копию
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));//пробегаемся по всем эл по данному локатору
        for(WebElement element: elements) {
            String name = element.getText();//для кажд эл вытаскиваем имя и id группы
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            groupCache.add(new GroupData().withId(id).withName(name));//созд.объект с такими атриб. и помещаем его в мн-во
        }
        return (groupCache);//возвр копию кеша
    }
}


