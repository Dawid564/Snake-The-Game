package com.snake.logic;

import com.snake.engine.Engine;
import com.snake.gui.GameGui;

public class Run {
    public Run(String[] args){
        GameGui gameGui = new GameGui(); //main gui controller
        Engine engine = new Engine(20, gameGui.getGame()); //engine
        gameGui.setEngine(engine);
        gameGui.run(args);
    }
}
