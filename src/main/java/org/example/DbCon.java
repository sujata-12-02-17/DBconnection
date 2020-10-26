package org.example;

import org.example.uitl.DbConnectionUtil;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.*;

/**
 * Hello world!
 *
 */
public class DbCon  {
    List<String>lStudents=new ArrayList<String>();
    private void inputStudentName() {
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


    public void saveStudent(final List<String> anyList) {
        final DbConnectionUtil connectionUtil = new DbConnectionUtil();
        final Connection con = connectionUtil.getDbConnection();
        if (con != null) {
            try {
                final PreparedStatement st = con.prepareStatement("INSERT INTO STUDENT (fname,lastName) VALUES(?,?)");
                for (final String name : anyList) {
                    System.out.println(name);
                    final String[] arr = name.split(" ");
                    final String fname = arr[0];
                    final String lastName = arr[1];
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

    public List<String> readFile() throws IOException {
        final String str = null;
        final List<String> lStudents = new ArrayList<String>();
        final DbConnectionUtil dbUtil = new DbConnectionUtil();
        final Connection con = dbUtil.getDbConnection();
        if (con != null) {
            try {
                final Statement st = con.createStatement();
                final ResultSet rs = st.executeQuery("SELECT * from student");
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
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
       DbCon d=new DbCon();

        int choice = 0;
        List<String> newList = null;

        do {
            System.out.println("Student Details..");
            System.out.println("1.Enter Student name");
            System.out.println("2.Save Students");
            System.out.println("3.Read file");
            System.out.println("4.exit");
            System.out.println("Enter your choice:");
            choice = sc.nextInt();
            switch (choice) {

                case 1:
                    System.out.println("Enter student names:");
                    d.inputStudentName();
                    System.out.println(d.lStudents);

                    break;
                case 2:
                    System.out.println("Saving student...");
                    d.saveStudent(d.lStudents);

                    break;
                case 3:

                    System.out.println("Read file");

                    List<String>  newList1=d.readFile();
                    newList1=d.readFile();
                    for (String str: newList1) {
                        System.out.println(str);
                    }
                    break;
                case 4:
                    System.exit(0);
            }

        } while (true);
    }




}