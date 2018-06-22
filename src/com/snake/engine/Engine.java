package com.snake.engine;

import com.snake.dao.Params;
import com.snake.dao.Snake;
import com.snake.gui.Game;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Engine{

    public enum Direction{UP,DOWN,LEFT,RIGHT}
    private Params params;
    private Game game;
    private int[] coordinateX;
    private int[] coordinateY;
    private List<Snake> snakeTail;

    public Engine(Params params, Game game){
        this.params = params;
        this.game = game;
        initialize();
    }

    //initialize components
    private void initialize(){
        //draw grid for snake
        drawGrid();

        calculateCoordinates();

        snakeTail = new ArrayList<>();
        Snake snakeHead = startSnake();
        drawSnake(snakeHead);
        snakeTail.add(snakeHead);
    }

    private Snake startSnake(){
        return new Snake(
                coordinateX[coordinateX.length/2],
                coordinateY[coordinateY.length/2],
                coordinateX[(coordinateX.length/2)+1],
                coordinateY[(coordinateY.length/2)+1]);
    }

    //draw snake
    private void drawSnake(Snake s){
        GraphicsContext gc = game.getGc();
        gc.setFill(Color.BLUE);
        gc.fillRect(s.getX1(),s.getY1(),getSnakeWidth(),getSnakeHeight());
    }

    private int getSnakeHeight(){
        return coordinateY[1] - coordinateY[0];
    }

    private int getSnakeWidth(){
        return coordinateX[1] - coordinateX[0];
    }

    //calculate all possible coordinates for snake
    private void calculateCoordinates(){
        coordinateX = new int[params.getPreferSize()];
        coordinateY = new int[params.getPreferSize()];
        for(int i=0; i<params.getPreferSize(); i++){
            coordinateY[i] = (params.getHeight()/params.getPreferSize())*i;
        }
        coordinateX = coordinateY;
    }


    public void selectDirection(Direction direct){
        switch (direct){
            case UP: moveUp(); break;
            case DOWN: moveDown(); break;
            case LEFT: moveLeft(); break;
            case RIGHT: moveRight(); break;
        }
    }

    //find where in array is the actual coordinates of snake
    private int findIndexY(int coordinates){
        for(int i=0; i<coordinateY.length; i++){
            if(coordinates == coordinateY[i]){
                return i;
            }
        }
        return -1;
    }

    private int findIndexX(int coordinates){
        for(int i=0; i<coordinateX.length; i++){
            if(coordinates == coordinateX[i]){
                return i;
            }
        }
        return -1;
    }



    private void moveLeft(){
        int elem = findIndexX(snakeTail.get(0).getX1());
        snakeTail.get(0).setX1(coordinateY[elem - 1]);
        drawSnake(snakeTail.get(0));
    }

    private void moveRight(){
        int elem = findIndexX(snakeTail.get(0).getX1());
        snakeTail.get(0).setX1(coordinateX[elem + 1]);
        drawSnake(snakeTail.get(0));
    }

    private void moveDown(){
        int elem = findIndexY(snakeTail.get(0).getY1());
        snakeTail.get(0).setY1(coordinateY[elem + 1]);
        drawSnake(snakeTail.get(0));
    }

    private void moveUp(){
        int elem = findIndexY(snakeTail.get(0).getY1());
        snakeTail.get(0).setY1(coordinateY[elem-1]);
        drawSnake(snakeTail.get(0));
    }



    //create grid for snake
    private void drawGrid(){
        GraphicsContext gc = game.getGc();
        gc.setFill(Color.BLACK);
        gc.setStroke(Color.BLACK);

        double y;
        for (int i=0; i<params.getPreferSize(); i++){
            y = (params.getHeight()/params.getPreferSize())*i;
            gc.strokeLine(0,y,params.getWidth(),y);
        }

        double x;
        for (int i=0; i<params.getPreferSize(); i++){
            x = (params.getWidth()/params.getPreferSize())*i;
            gc.strokeLine(x,0,x,params.getHeight());
        }
    }
}
