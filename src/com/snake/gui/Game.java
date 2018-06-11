package com.snake.gui;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Game {

    public Game(Stage stage){
        stage.setTitle("Snake");
        stage.setScene(new Scene(new StackPane(),300,250));
        stage.show();
    }
}
