package ru.Bykova.JAVA_lessons.addressbook.tests;

import org.testng.annotations.Test;
import ru.Bykova.JAVA_lessons.addressbook.model.GroupData;
import ru.Bykova.JAVA_lessons.addressbook.model.Groups;

import java.sql.*;

public class DbConnectionTest {

    @Test
    public  void testDbConnection() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook?user=root&password=&serverTimezone=UTC");//уст.соед-е с БД

            Statement st = conn.createStatement();//получ инфу из БД
            ResultSet rs = st.executeQuery("select group_id,group_name,group_header,group_footer from group_list");//делаем запрос
            Groups groups = new Groups();//сюда доб созд-е объекты
            while (rs.next()) {//пока есть еще какие-то элементы
                groups.add(new GroupData().withId(rs.getInt("group_id")).withName(rs.getString("group_name"))
                        .withHeader(rs.getString("group_header")).withFooter(rs.getString("group_footer")));
            }
            rs.close();//освобождаем ресурсы,память
            st.close();//не собир больше вып никакие запросы
            conn.close();//закр соед-е с БД

            System.out.println(groups);

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}
