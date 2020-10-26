package org.example.app;

import org.example.uitl.DbConnectionUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
    public static void main(String[] args) {


        DbConnectionUtil dbUtil = new DbConnectionUtil();
        Connection con = dbUtil.getDbConnection();
        if (con != null) {
            try {
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT VERSION()");
                if (rs.next()) {
                    System.out.println(rs.getString(1));
                }
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }


    }
}


