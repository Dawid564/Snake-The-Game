package com.snake.engine;

import com.snake.dao.Params;

import static com.snake.engine.Engine.Direction.*;

public class Move implements Runnable {

    private Engine engine;
    private Params params;

    //default value
    private Engine.Direction direction = UP;

    public Move(Engine engine, Params params){
        this.engine = engine;
        this.params = params;
    }

    @Override
    public void run() {
        //autoMove();
    }

    public void autoMove(){
        while (true){
            engine.selectDirection(this.direction);
            try {
                Thread.sleep(params.getSnakeSpeed());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void direct(Engine.Direction direction){
        this.direction = direction;
    }
}
