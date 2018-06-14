package com.snake.engine;

import com.snake.gui.GameGui;

public class Engine {

    private int preferSize = 20;
    private int[] map = null;
    private GameGui gameGui;

    public Engine(int preferSize, GameGui gameGui){
        this.preferSize = preferSize;
        this.gameGui = gameGui;
    }

    public void createMap(){
        this.map = new int[preferSize];
    }

}
