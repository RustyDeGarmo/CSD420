/*
Rusty DeGarmo
Professor Payne
Advanced Java
28 November 2021
*/


/*
The purpose of this program is to use CSS to style some
objects in a Java FX program.
*/

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Circles extends Application{
    public static void main(String[] args){
        launch(args);
    }

    @Override // override the start method
    public void start(Stage primaryStage){
        HBox hBox = new HBox(5);
        Scene scene = new Scene(hBox, 325, 250);
        scene.getStylesheets().add("style.css"); //load the stylesheet

        //create a pane for the first circle with a border
        Pane pane1 = new Pane();
        Circle circle1 = new Circle(40, 125, 35);
        pane1.getChildren().add(circle1);
        pane1.getStyleClass().add("border");

        //set the style for the first circle
        circle1.getStyleClass().add("plaincircle");

        //create a pane for three more circles without a border
        Pane pane2 = new Pane();
        Circle circle2 = new Circle(40, 125, 35);
        Circle circle3 = new Circle(115, 125, 35);
        Circle circle4 = new Circle(190, 125, 35);
        pane2.getChildren().addAll(circle2, circle3, circle4);

        //set the styles for the other three circles
        circle2.getStyleClass().add("plaincircle");
        circle3.setId("redcircle");
        circle4.setId("greencircle");

        hBox.getChildren().addAll(pane1, pane2);

        primaryStage.setTitle("Stylin' Circles");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}