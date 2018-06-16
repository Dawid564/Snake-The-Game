package com.snake.logic;

import com.snake.engine.Engine;
import com.snake.gui.GameGui;

public class Run {
    public Run(String[] args){
        GameGui gameGui = GameGui.getInstance(); //main gui controller
        new Thread (() ->{
            System.out.println("hoho");
            Engine engine = new Engine(20, gameGui.getGame()); //engine
            gameGui.setEngine(engine);
        }).start();
        gameGui.runGui();
        //gameGui.run(args); remove

    }
}
