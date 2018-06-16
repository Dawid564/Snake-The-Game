package com.snake.gui;

import com.snake.engine.Engine;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


//game window
public class Game {

    private GraphicsContext gc = null;
    private Engine engine;

    private void initEngine(){
        Engine engine = new Engine(20, this);
    }

    public Game(Stage primaryStage){
        initEngine();
        primaryStage.setTitle("Snake - Drawing test :D");
        Group root = new Group();
        Canvas canvas = new Canvas(300,250);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        this.gc = gc;
        drawPolygons(gc);
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private void drawPolygons(GraphicsContext gc){
        gc.setFill(Color.RED);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(5);
        gc.strokeLine(10,10,40,10);
    }

    public void drawMap(int size){

    }

    public void drawSnake(){

    }

    public void setEngine(Engine engine){
        this.engine = engine;
    }
}
