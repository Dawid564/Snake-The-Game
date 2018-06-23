package com.snake.engine;

public class Move implements Runnable {

    @Override
    public void run() {
        test();
    }

    private void test(){
        while(true){
            System.out.println("test");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
