package employe.management.system;

import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;


public class Conn {

    Connection connection;
    Statement statement;

    public Conn(){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/staffsphere","root","sakalakaboomboom999");
            statement = connection.createStatement();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
