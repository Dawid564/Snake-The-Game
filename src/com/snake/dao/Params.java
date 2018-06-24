package com.snake.dao;

public class Params {

    private int height;
    private int width;
    private int preferSize;//count of square in one column
    private int snakeSpeed;//snake speed in millis

    public Params(int height, int width, int preferSize, int snakeSpeed){
        this.height = height;
        this.width = width;
        this.preferSize = preferSize;
        this.snakeSpeed = snakeSpeed;
    }

    public int getSnakeSpeed() {
        return snakeSpeed;
    }

    public void setSnakeSpeed(int snakeSpeed) {
        this.snakeSpeed = snakeSpeed;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getPreferSize() {
        return preferSize;
    }

    public void setPreferSize(int preferSize) {
        this.preferSize = preferSize;
    }
}
