package com.snake.engine;

import com.snake.dao.Snake;

import java.util.List;
import java.util.Random;

public class SnakeFood {

    private Random rand;
    private enum Axis{X,Y}

    public int[] initFood(int[] x, int[] y, List<Snake> snakeTail){
        int lenOfMap = convertToNum(x,y);
        int[] excludes = calculateExclude(x,y,snakeTail);
        return null;
    }

    private int[] calculateExclude(int[] x, int[] y, List<Snake> snakeTail){
        System.out.println("snake size " + snakeTail.size());
        int[] excludes = new int[snakeTail.size()];
        for(int i=0; i<snakeTail.size(); i++){
            System.out.println("test");
            excludes[i] = calcExcludePos(findIndex(x,snakeTail.get(i),Axis.X), findIndex(y,snakeTail.get(i),Axis.Y),x,y);

        }
        return null;
    }

    private int calcExcludePos(int a, int b, int[] x, int[] y){
        getElemLocalization(getArrayPosition(a, Axis.X, x), getArrayPosition(b,Axis.Y, y));
        return 0;
    }

    private int getElemLocalization(int a, int b){
        System.out.println(a + " "  + b);
        return -1;
    }

    private int getArrayPosition(int a, Axis axis, int[] coordinate){
        switch (axis){
            case X:
                for (int i=0; i<coordinate.length-1; i++){
                    if(coordinate[i] == a){
                        return i;
                    }
                }
                break;
            case Y: for (int i=0; i<coordinate.length-1; i++){
                if(coordinate[i] == a){
                    return i;
                }
            } break;
        }
        return -998;
    }

    private int findIndex(int[] array, Snake snake, Axis axis){
        int direct = 0;
        switch (axis){
            case X: direct = getDirect(array, snake.getX1());
                break;
            case Y: direct = getDirect(array, snake.getY1());
                break;
        }
        if(direct == -999){
            System.out.println("error with convert -999");
        }
        return direct;
    }

    private int getDirect(int[] array, int directions){
        for(int i=0; i<array.length; i++){
            if(array[i] == directions){
                return directions;
            }
        }
        return -999;
    }

    private int convertToNum(int[] x, int[] y){
        return x.length * y.length;
    }

}
