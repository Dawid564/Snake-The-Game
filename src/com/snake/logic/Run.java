package com.snake.logic;

import com.snake.gui.GameGui;

public class Run {
    public Run(String[] args){
        GameGui gameGui = new GameGui();
        gameGui.run(args);
    }
}
