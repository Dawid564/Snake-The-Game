package com.snake.gui;

import com.snake.engine.Engine;
import javafx.application.Application;
import javafx.stage.Stage;

public class GameGui extends Application{

    private Game game;
    private Engine engine;

    public static void run(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Game game = new Game(primaryStage);
        this.game = game;
    }

    public void setEngine(Engine engine){
        this.engine = engine;
    }
}
