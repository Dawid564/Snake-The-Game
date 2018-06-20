package com.snake.dao;

public class Params {

    private int height;
    private int width;
    private int preferSize;

    public Params(int height, int width, int preferSize){
        this.height = height;
        this.width = width;
        this.preferSize = preferSize;
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
