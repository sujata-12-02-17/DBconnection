package org.example.app;

import org.example.app.IOperations;
import org.example.uitl.DbConnectionUtil;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbOpration implements IOperations {
    List<String> lStudents=new ArrayList<String>();

    @Override
    public void inputStudentName() {
        try{

            InputStreamReader reder=new InputStreamReader(System.in);
            BufferedReader br=new BufferedReader(reder);
            this.lStudents.add(br.readLine());
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();


        }
    }
    @Override
    public List<String> readFile() {
         String str = null;
         List<String> lStudents = new ArrayList<String>();
         DbConnectionUtil dbUtil = new DbConnectionUtil();
         Connection con = dbUtil.getDbConnection();
        if (con != null) {
            try {
                 Statement st = con.createStatement();
                 ResultSet rs = st.executeQuery("SELECT * from student");
                while (rs.next()) {
                    lStudents.add(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
                }
                con.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return lStudents;
    }

    @Override
    public void saveStudent(List<String> anyList) {
        DbConnectionUtil connectionUtil = new DbConnectionUtil();
        Connection con = connectionUtil.getDbConnection();
        if (con != null) {
            try {
                PreparedStatement st = con.prepareStatement("INSERT INTO STUDENT (fname,lastName) VALUES(?,?)");
                for ( String name : anyList) {
                    System.out.println(name);
                    String[] arr = name.split(" ");
                    String fname = arr[0];
                    String lastName = arr[1];
                    st.setString(1, fname);
                    st.setString(2, lastName);
                    st.executeUpdate();
                }
                con.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
