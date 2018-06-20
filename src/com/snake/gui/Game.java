package com.snake.gui;

import com.snake.dao.Params;
import com.snake.engine.Engine;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;


//game window
public class Game {

    private GraphicsContext gc = null;
    private Engine engine;

    private void initEngine(Params params){
        Engine engine = new Engine(params, this);
        this.engine = engine;
    }

    public GraphicsContext getGc() {
        return gc;
    }

    public Game(Stage primaryStage){
        Params params = initParams();
        primaryStage.setTitle("Snake - Drawing test :D");
        Group root = new Group();
        Canvas canvas = new Canvas(params.getWidth(),params.getHeight());
        GraphicsContext gc = canvas.getGraphicsContext2D();
        this.gc = gc;
        initEngine(params);

        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private Params initParams(){
        return new Params(300,300,20);
    }
}
