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
    private Move move;
    private Params params;
    private Game game;
    private SnakeFood snakeFood;
    private int[] coordinateX;
    private int[] coordinateY;
    private int[] foodCoordinates;
    private List<Snake> snakeTail;
    public enum Operator{
        ADD{
            @Override
            public int apply (int a, int b){
                return a + b;
            }
        },
        SUB{
            @Override
            public  int apply (int a, int b){
                return a - b;
            }
        };

        public abstract int apply(int a, int b);
    }

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

        //TODO AFTER TESTS DELETE !
        Snake snakeHead1 = startSnakeTEST1();
        drawSnake(snakeHead1);
        snakeTail.add(snakeHead1);

        //TODO AFTER TESTS DELETE !
        Snake snakeHead2 = startSnakeTEST2();
        drawSnake(snakeHead2);
        snakeTail.add(snakeHead2);

        //object of background operations
        Move move = initAutoMove();
        this.move = move;

        //SnakeFood snakeFood = new SnakeFood(coordinateX,coordinateY,snakeTail);
        setUpFood();

    }

    private void setUpFood(){
        SnakeFood snakeFood = new SnakeFood();
        snakeFood.setUpParams(params);
        foodCoordinates = snakeFood.initFood(coordinateX,coordinateY,snakeTail);
        //draw food
        drawSnakeFood(foodCoordinates);
    }

    private void drawSnakeFood(int[] coordinates){
        GraphicsContext gc = game.getGc();
        gc.setFill(Color.RED);
        gc.fillRect(coordinateX[coordinates[0]],coordinateY[coordinates[1]],getSnakeWidth(),getSnakeHeight());
    }

    private Move initAutoMove(){
        Move move = new Move(this ,params);
        new Thread(move).start();
        return move;
    }

    private Snake startSnake(){
        return new Snake(
                coordinateX[coordinateX.length/2],
                coordinateY[coordinateY.length/2],
                coordinateX[(coordinateX.length/2)+1],
                coordinateY[(coordinateY.length/2)+1]);
    }

    //TODO AFTER TEST DELETE!
    private Snake startSnakeTEST1(){
        return new Snake(
                coordinateX[coordinateX.length/2],
                coordinateY[coordinateY.length/2+1],
                coordinateX[(coordinateX.length/2)+1],
                coordinateY[(coordinateY.length/2)+1]);
    }

    //TODO AFTER TEST DELETE!
    private Snake startSnakeTEST2(){
        return new Snake(
                coordinateX[coordinateX.length/2],
                coordinateY[coordinateY.length/2+2],
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
        move.direct(direct);
        switch (direct){
            case UP: moveSnakeHead(Operator.SUB, Direction.UP); break;
            case DOWN: moveSnakeHead(Operator.ADD, Direction.DOWN); break;
            case LEFT: moveSnakeHead(Operator.SUB, Direction.LEFT); break;
            case RIGHT: moveSnakeHead(Operator.ADD, Direction.RIGHT); break;
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
    //TODO add max to operate!!
    private int findIndexX(int coordinates){
        for(int i=0; i<coordinateX.length; i++){
            if(coordinates == coordinateX[i]){
                return i;
            }
        }
        return -1;
    }

    private int[][] getVectorList(List<Snake> snakeTailFun){
        int[][] vectors = new int[snakeTailFun.size()-1][2];

        //fill vectors
        for (int i=0; i<snakeTail.size()-1; i++){
            vectors[i][0] = snakeTail.get(i).getX1();
            vectors[i][1] = snakeTail.get(i).getY1();
        }

        return vectors;
    }

    private int getSnakeElement(Direction direction){
        int elem;
        if(Direction.LEFT.equals(direction) || Direction.RIGHT.equals(direction)){
            elem = findIndexX(snakeTail.get(0).getX1());
        }else{
            elem = findIndexY(snakeTail.get(0).getY1());
        }

        return elem;
    }

    private void moveSnakeHead(Operator op, Direction direction){
        clearMap();

        int elem = getSnakeElement(direction);
        Snake head = snakeTail.get(0); //copy snake head

        //vectors for every snake element
        int[][] vectors = getVectorList(snakeTail);

        //update snake
        for(int i=0; i<snakeTail.size()-1; i++){
            snakeTail.get(i+1).setX1(vectors[i][0]);
            snakeTail.get(i+1).setY1(vectors[i][1]);
        }

        //update snake head
        if(Direction.LEFT.equals(direction) || Direction.RIGHT.equals(direction)){
            head.setX1(coordinateY[op.apply(elem,1)]);
        }else{
            System.out.println("elem " + elem);
            head.setY1(coordinateY[op.apply(elem,1)]);
        }

        snakeTail.set(0,head);
        for(Snake s : snakeTail){
            drawSnake(s);
        }
        addSnake();

    }

    //if found food
    private void addSnake(){
        if(snakeTail.get(0).getX1() == coordinateX[foodCoordinates[0]] && snakeTail.get(0).getY1() == coordinateY[foodCoordinates[1]]){
            Snake snakeModern = new Snake(snakeTail.get(snakeTail.size()-1).getX1(), snakeTail.get(snakeTail.size()-1).getY1(), 0,0);
            snakeTail.add(snakeModern);
            setUpFood();
        }
    }

    //clear objects and redraw grid
    //use this always if you need to move object
    private void clearMap(){
        game.getGc().clearRect(0,0,params.getWidth(),params.getHeight());
        drawGrid();
        drawSnakeFood(this.foodCoordinates);
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
