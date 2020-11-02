package org.example.app;

import org.example.app.DbOpration;
import org.example.app.IOperations;
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
public class DbCon   {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
       //DbCon d=new DbCon();
        IOperations iOperations = new DbOpration();
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
                    iOperations.inputStudentName();

                    System.out.println(((DbOpration) iOperations).lStudents);

                    break;
                case 2:
                    System.out.println("Saving student...");
                    iOperations.saveStudent(((DbOpration) iOperations).lStudents);

                    break;
                case 3:

                    System.out.println("Read file");

                    List<String>  newList1=iOperations.readFile();
                    newList1=iOperations.readFile();
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