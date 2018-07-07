package com.snake.gui;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GameOver {

    private Stage stage;

    public GameOver(){
        stage = new Stage();
        stage.setTitle("Game Over");
        StackPane root = new StackPane();
        Label label = new Label("Game Over");
        label.setFont(new Font(40));
        root.getChildren().add(label);
        stage.setScene(new Scene(root, 250, 150));
        stage.show();
    }
}
