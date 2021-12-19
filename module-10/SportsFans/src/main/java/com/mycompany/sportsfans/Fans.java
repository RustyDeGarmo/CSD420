/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt 
to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit 
this template
 */
package com.mycompany.sportsfans;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Rusty DeGarmo
 */
public class Fans extends Application {
    
    private final JDBCMySQLConnection fanDAO = new JDBCMySQLConnection();
    private final ObservableList<Fan> observableFans;
    
    //Placeholder strings just to display something for now
    //will update later
    String holder = "0";
    String holder1 = "Jeff";
    String holder2 = "Holden";
    String holder3 = "Packers";
    
    //All of the GUI nodes
    Label lblID = new Label("ID: ");
    Label lblFName = new Label("First Name: ");
    Label lblLastName = new Label("Last Name: ");
    Label lblFavTeam = new Label("Favorite Team: ");
    
    TextField tfDisplayID = new TextField(holder);
    TextField tfDisplayFirstName = new TextField(holder1);
    TextField tfDisplayLastName = new TextField(holder2);
    TextField tfDisplayFavTeam = new TextField(holder3);
    
    TextField tfID = new TextField();
    TextField tfFirstName = new TextField();
    TextField tfLastName = new TextField();
    TextField tfFavTeam = new TextField();
    
    Button display = new Button("Display Entry");
    Button update = new Button("Update Entry");

    public Fans(){
        observableFans = FXCollections.observableArrayList
                (fanDAO.getFans());
    }
    
    @Override //override the start method
    public void start(Stage primaryStage) throws Exception {
        ObservableList<Fan> fanList = 
                FXCollections.observableArrayList();
        observableFans.forEach(Fan -> fanList.add(Fan));

        //create the UI
        BorderPane root = new BorderPane();
        
        HBox buttonBox = new HBox();
        buttonBox.getChildren().addAll(display, update);
        
        HBox tfDisplayBox = new HBox();
        tfDisplayBox.getChildren().addAll(tfDisplayID, tfDisplayFirstName, 
                tfDisplayLastName, tfDisplayFavTeam);
        
        HBox tfBox = new HBox();
        tfBox.getChildren().addAll(tfID, tfFirstName, tfLastName, tfFavTeam);
        VBox inputBox = new VBox();
        Label inputLabel = new Label("Enter an ID to see the result and " +
                "enter new data to update");
        inputBox.getChildren().addAll(inputLabel, tfBox);
        
        
        //This Tableview Section was going to be removed if I could 
        //get it working with text fields
        TableView<Fan> table = new TableView<>();
        table.setItems(fanList);
        
        TableColumn labelCol = new TableColumn("ID");
        labelCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn firstNameCol = new TableColumn("First Name");
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("fName"));
        TableColumn lastNameCol = new TableColumn("Last Name");
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lName"));
        TableColumn favTeamCol = new TableColumn("Favorite Team");
        favTeamCol.setCellValueFactory(new PropertyValueFactory<>("favTeam"));
        
        table.getColumns().addAll(labelCol, firstNameCol, lastNameCol, 
                favTeamCol);
        
        
        
        root.setTop(tfDisplayBox);
        root.setCenter(inputBox);
        root.setBottom(buttonBox);
        
        
        Scene scene = new Scene(root, 400, 100);
        
        display.setOnAction(event -> {
            String text = tfID.getText();
            int userID = Integer.parseInt(text);
            fanList.forEach(Fan -> {
                
                if(Fan.getId() == (Integer)userID){
                    tfDisplayID.setText(text);
                    tfDisplayFirstName.setText(Fan.getFName());
                    tfDisplayLastName.setText(Fan.getLName());
                    tfDisplayFavTeam.setText(Fan.getFavTeam());
                }
                });
        });
        
        update.setOnAction(event -> {
            String text = tfID.getText();
            int userID = Integer.parseInt(text);
            
            fanList.forEach(Fan -> {
                
            
                if(Fan.getId() == (Integer)userID){
                    if(tfFirstName.getText() != null){
                String userName = tfFirstName.getText();
                Fan.setFName(userName);
                }
                if(tfLastName.getText() != null){
                    String userLastName = tfLastName.getText();
                    Fan.setLName(userLastName);
                }
                if(tfFavTeam.getText() != null){
                    String userFavTeam = tfFavTeam.getText();
                    Fan.setFavTeam(userFavTeam);
                }
                    
                    
                    
                }
            });
            
        });
        
        primaryStage.setTitle("Welcome Sports Fans");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    
    public static void main(String[] args){   
        launch(args);
    }
}
