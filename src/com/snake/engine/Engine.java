package com.snake.engine;

public class Engine {

    int preferSize = 20;
    int[] map = null;

    public Engine(){}

    public Engine(int preferSize){
        this.preferSize = preferSize;
    }

    public void createMap(){
        this.map = new int[preferSize];
    }

}
