package com.snake.engine;

public class Move implements Runnable {

    private Engine engine;

    public Move(Engine engine){
        this.engine = engine;
    }

    @Override
    public void run() {
        autoMove();
    }

    public void autoMove(){

    }
}
