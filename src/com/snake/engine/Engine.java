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
    private int[] coordinateY;

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

        drawSnake(startSnake());
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
        System.out.println(s.getX1() + " " +  s.getY1() + " " +  s.getX2() + " " +  s.getY2());
        GraphicsContext gc = game.getGc();
        gc.setFill(Color.BLUE);
        gc.fillRect(s.getX2(), s.getY1(), s.getX1(), s.getY2());
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
