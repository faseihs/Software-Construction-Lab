package com.company;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        try{
            int j=1;
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/university", "root", "root");
            Scanner input = new Scanner(System.in);
            while(j==1) {
                Statement stmt = null;
                ResultSet rs = null;
                System.out.println("\nWHAT DO YOU WANT TO DO");
                System.out.println("\n1-DISPLAY ALL DATA");
                System.out.println("\n2-DELETE AN ENTRY");
                System.out.println("\n3-SEARCH FOR ENTRY");

                int i = input.nextInt();
                if (i == 1) {
                    stmt = con.createStatement();
                    rs = stmt.executeQuery("select * from student");

                    System.out.println("Sr.  Name\tReg.no\tClass\tSection\tNumber\t\tAddress");
                    while (rs.next()) {
                        for (int k = 1; k <= 7; k++) {
                            System.out.print(rs.getString(k) + " \t");
                        }
                        System.out.println("\n");
                        //System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
                    }
                }
                else if (i == 2) {
                    System.out.println("\nENTER REGISTRATION TO DELETE");

                    int reg = input.nextInt();
                    stmt = con.createStatement();
                    String query = "SELECT * from student WHERE reg_no=" + reg;
                    rs = stmt.executeQuery(query);
                    if (rs.first()) {
                        stmt = con.createStatement();
                        query = "DELETE from student WHERE reg_no=" + reg;
                        PreparedStatement preparedStatement = con.prepareStatement(query);
                        preparedStatement.executeUpdate();
                        System.out.println("DELETED ");
                    } else System.out.println("\nThe Specified Registration Number does not exist");
                }
                else if(i==3){
                    System.out.println("\nENTER NAME TO SEARCH");
                    input.skip("[\r\n]+");
                    String name=input.nextLine();
                    stmt = con.createStatement();
                    String query = "SELECT * from student WHERE name='" + name+"'";
                    rs = stmt.executeQuery(query);
                    if(rs.first()){
                        //rs.next();
                        System.out.println("Sr.  Name\tReg.no\tClass\tSection\tNumber\t\tAddress");
                        for (int k = 1; k <= 7; k++) {
                            System.out.print(rs.getString(k) + " \t");
                        }
                        System.out.println("\n");
                    }
                    else{
                        System.out.println("\nSTUDENT NOT PRESENT");
                    }

                }
                else{
                    System.out.println("\nWRONG OPTION SELCTED");
                }
                System.out.println("\nWANT TO DO ANOTHER QUERY, PRESS (1)");
                j=input.nextInt();
            }


            con.close();
        }catch(Exception e){ System.out.println("The Error is :"+e.getMessage());}
    }
}
