/**
 *
 * @author Rusty DeGarmo
 * Professor Payne
 * Advanced Java
 * 12 December 2021
 * 
 */

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sportsfans;

import java.sql.*;
import java.util.ArrayList;

public class JDBCMySQLConnection {
    //database connection info
        Connection connection;
        Statement statement;

        final String driver = "com.mysql.cj.jdbc.Driver";
        final String url = "jdbc:mysql://localhost:3306/databasedb?";
        final String username = "student1";
        final String password = "pass";
        
    private Fan createSportsFan(ResultSet rs){
        Fan fan = new Fan();
        try{
            fan.setId(rs.getInt("ID"));
            fan.setFName(rs.getString("FIRSTNAME"));
            fan.setLName(rs.getString("LASTNAME"));
            fan.setFavTeam(rs.getString("FAVORITETEAM"));
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return fan;
    }
    
    public ArrayList<Fan> getFans(){
        //MySQL query statement
        String sqlCommand = "Select * from fans;";
        ArrayList<Fan> list = new ArrayList<>();
        
        
        //try the connection
        try{
            Class.forName(driver);
            connection = DriverManager.getConnection(
                url, username, password);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlCommand);
            while(resultSet.next()){
                Fan fan = createSportsFan(resultSet);
                list.add(fan);
            }
            resultSet.close();
            connection.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return list;
    }
    public ArrayList<Fan> getFanById(int id){
        String sqlCommand = "Select * from fans where ID like '%" +
                id + "%'";
        ArrayList<Fan> list = new ArrayList<>();
        try{
            Class.forName(driver);
            connection = DriverManager.getConnection
                    (url, username, password);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlCommand);
            
            while(resultSet.next()){
                Fan fan = createSportsFan(resultSet);
                list.add(fan);
            }
            resultSet.close();
            connection.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return list;
    }
}
