package com.snake.gui;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GameOver {

    private Stage stage;

    public GameOver(){
        stage = new Stage();
        stage.setTitle("Game Over");
        StackPane root = new StackPane();
        stage.setScene(new Scene(root, 250, 200));
        stage.show();
    }
}
