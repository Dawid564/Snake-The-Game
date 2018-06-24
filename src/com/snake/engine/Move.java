package com.snake.engine;

import static com.snake.engine.Engine.Direction.*;

public class Move implements Runnable {

    private Engine engine;
    private Engine.Direction direction = UP;

    public Move(Engine engine){
        this.engine = engine;
    }

    @Override
    public void run() {
        autoMove();
    }

    public void autoMove(){
        while (true){
            engine.selectDirection(this.direction);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void direct(Engine.Direction direction){
        this.direction = direction;
    }
}
