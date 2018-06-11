package com.snake;

import com.snake.gui.GameGui;
import com.snake.logic.Run;
import javafx.application.Application;

public class App 
{
    public static void main( String[] args )
    {
        GameGui gameGui = GameGui.class;
        Application.launch(new GameGui(), args);
        new Run(args);
    }
}
