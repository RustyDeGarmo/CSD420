/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sportsfans;

/**
 *
 * @author Rusty DeGarmo
 */
public class Fan {
    private int id;
    private String fName;
    private String lName;
    private String favTeam;
    
    public Fan(){};
    
    public Fan(String fName, String lName, String favTeam){
        this.fName = fName;
        this.lName = lName;
        this.favTeam = favTeam;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getFName(){
        return fName;
    }
    
    public void setFName(String fname){
        this.fName = fname;
    }
    
    public String getLName(){
        return lName;
    }
    
    public void setLName(String lName){
        this.lName = lName;
    }
    
    public String getFavTeam(){
        return favTeam;
    }
    
    public void setFavTeam(String favTeam){
        this.favTeam = favTeam;
    }
}
