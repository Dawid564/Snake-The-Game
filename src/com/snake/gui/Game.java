package com.snake.gui;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;



public class Game {

    public Game(Stage primaryStage){
        primaryStage.setTitle("Snake - Drawing test :D");
        Group root = new Group();
        Canvas canvas = new Canvas(300,250);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        /*
        primaryStage.setScene(new Scene(new StackPane(),300,250));
        primaryStage.show();*/
    }

    private void drawPolygons(){

    }
}
