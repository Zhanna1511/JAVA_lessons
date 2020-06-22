package ru.Bykova.JAVA_lessons.mantis.tests;

import org.testng.annotations.Test;
import ru.Bykova.JAVA_lessons.mantis.model.Issue;
import ru.Bykova.JAVA_lessons.mantis.model.Project;

import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class SoapTests extends TestBase{

    @Test
    public void testGetProjects() throws MalformedURLException, ServiceException, RemoteException {
        Set<Project> projects = app.soap().getProjects();
        System.out.println(projects.size());
        for (Project project: projects){
            System.out.println(project.getName());
        }
    }

    @Test
    public void testCreateIssue() throws MalformedURLException, ServiceException, RemoteException{
        Set<Project> projects = app.soap().getProjects();
        Issue issue = new Issue().withSummary("Test issue")
                .withDescription("Test issue description").withProject(projects.iterator().next());
        Issue created = app.soap().addIssue(issue);
        assertEquals(issue.getSummary(), created.getSummary());

    }
}

//public class SoapTests extends TestBase {

    //@Test
    //public void testGetProject() throws MalformedURLException, ServiceException, RemoteException {//получ список проектов
       //Set<Project> projects = app.soap().getProjects();
        //System.out.println(projects.size());
        //for (Project project : projects) {
            //System.out.println(project.getName());
        //}
    //}

    //@Test
    //public void testCreateIssue() throws RemoteException, ServiceException, MalformedURLException {//баг-репорт
        //skipIfNotFixed(0);
        //Set<Project> projects = app.soap().getProjects();//получаем мн-во/список проектов
        //Issue issue = new Issue().withSummary("Test issue").withDescription("Test issue description")
                //.withProject(projects.iterator().next());
        //Issue created = app.soap().addIssue(issue);//новый объект сравниваем с существующим
        //assertEquals(issue.getSummary(), created.getSummary());
    //}
//}