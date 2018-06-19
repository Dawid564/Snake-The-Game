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
    private int height = 300;
    private int width = 300;

    private void initEngine(){
        Engine engine = new Engine(20, this);
        this.engine = engine;
    }

    public GraphicsContext getGc() {
        return gc;
    }

    public Game(Stage primaryStage){

        primaryStage.setTitle("Snake - Drawing test :D");
        Group root = new Group();
        Canvas canvas = new Canvas(width,height);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        this.gc = gc;
        initEngine();

        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void drawMap(int size){

    }

    public void drawSnake(){

    }

    public void setEngine(Engine engine){
        this.engine = engine;
    }
}
