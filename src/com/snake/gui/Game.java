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
    private Canvas canvas;

    private void initEngine(Params params){
        Engine engine = new Engine(params, this);
        this.engine = engine;
    }

    public GraphicsContext getGc() {
        return gc;
    }

    public Game(Stage primaryStage){
        Params params = initParams();
        primaryStage.setTitle("Snake :D");
        Group root = new Group();
        Canvas canvas = new Canvas(params.getWidth(),params.getHeight());
        this.canvas = canvas;
        GraphicsContext gc = canvas.getGraphicsContext2D();
        this.gc = gc;
        initEngine(params);

        root.getChildren().add(canvas);
        Scene mainScene = new Scene(root);

        primaryStage.setScene(mainScene);
        primaryStage.show();
        setUpUserInput(mainScene);
    }

    //set up reaction on arrow clicking
    private void setUpUserInput(Scene mainScene){
        mainScene.setOnKeyPressed(event ->{
            switch (event.getCode()){
                case UP: engine.selectDirection(Engine.Direction.UP); break;
                case DOWN: engine.selectDirection(Engine.Direction.DOWN); break;
                case LEFT: engine.selectDirection(Engine.Direction.LEFT); break;
                case RIGHT: engine.selectDirection(Engine.Direction.RIGHT); break;
            }
        });
    }

    private Params initParams(){
        return new Params(300,300,20, 500);
    }
}
