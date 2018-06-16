package com.snake.gui;

import javafx.application.Application;
import javafx.stage.Stage;

//main place to start gui
public class GameGui extends Application {

    public static void run(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        new Game(primaryStage);
    }
}
