package com.snake.gui;

import javafx.application.Application;
import javafx.stage.Stage;

public class GameGui extends Application{
/*
    public GameGui(String[] args){
        launch(this.getClass(), args);
    }
*/
    @Override
    public void start(Stage primaryStage) throws Exception {
        new Game(primaryStage);
    }
}
