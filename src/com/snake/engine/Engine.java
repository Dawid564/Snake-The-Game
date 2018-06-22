package com.snake.engine;

import com.snake.dao.Params;
import com.snake.dao.Snake;
import com.snake.gui.Game;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Engine{

    public enum Direction{UP,DOWN,LEFT,RIGHT}
    private Params params;
    private Game game;
    private int[] coordinateX;
    private int[] coordianteY;

    public Engine(Params params, Game game){
        this.params = params;
        this.game = game;
        initialize();
    }

    //initialize components
    private void initialize(){
        //draw grid for snake
        drawGrid();
    }

    //draw snake
    private void drawSnake(Snake snake){

    }

    //calculate all possible coordinates for snake
    private void calculateCoordinates(){

    }


    public void selectDirection(Direction direct){

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
