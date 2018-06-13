package com.snake.logic;

import com.snake.engine.Engine;
import com.snake.gui.GameGui;

public class Run {
    public Run(String[] args){
        Engine engine = new Engine(20);

        GameGui gameGui = new GameGui();
        gameGui.run(args);
    }
}
