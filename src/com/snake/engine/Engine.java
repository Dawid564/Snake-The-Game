package com.snake.engine;

import com.snake.gui.Game;

public class Engine {

    private int preferSize = 20;
    private int[] map = null;
    private Game game;

    public Engine(int preferSize, Game game){
        this.preferSize = preferSize;
        this.game = game;
    }

    public void createMap(){
        this.map = new int[preferSize];
    }

}
