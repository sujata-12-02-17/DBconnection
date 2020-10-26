package org.example.uitl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectionUtil {

    private String url="jdbc:mysql://localhost:3306/testdb?useSSL=false";
    private String username="root";
    private String password="sujata";

    public Connection getDbConnection(){
        Connection con = null;
        try {
            con = DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}

