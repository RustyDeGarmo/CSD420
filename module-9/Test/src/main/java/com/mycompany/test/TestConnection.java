/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.test;

/**
 *
 * @author Rusty DeGarmo
 */
//path to mysql: C:\Program Files\MySQL\MySQL Server 8.0\bin

//create test user: CREATE USER test@'localhost' IDENTIFIED BY 'pass';

//grant test user all privileges: GRANT ALL PRIVILEGES ON * . * TO test@'localhost';

import java.net.URL;
import java.sql.*;

public class TestConnection{
    public static void main(String[] args) throws SQLException, ClassNotFoundException{
        // Load the JDBC driver
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded");

        try ( //connect to database
            Connection connection = DriverManager.getConnection
                ("jdbc:mysql://localhost/testdata", "test", "pass")) {
            System.out.println("Database Connected");
            //create a statement
            Statement statement = connection.createStatement();
            //execute a statement
            ResultSet resultSet = statement.executeQuery
                    ("select firstName, mi, lastName from Student where lastName "
                            + " = 'Smith'");
            //iterate through the result and print the student names
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + "\t" +
                        resultSet.getString(2) + "\t" + resultSet.getString(3));
            }
            //close the connection
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

