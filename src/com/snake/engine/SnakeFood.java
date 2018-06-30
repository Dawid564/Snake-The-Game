package com.snake.engine;

import com.snake.dao.Params;
import com.snake.dao.Snake;

import java.util.List;
import java.util.Random;

public class SnakeFood {

    private Random rand;
    private enum Axis{X,Y}
    private Params params;

    public int[] initFood(int[] x, int[] y, List<Snake> snakeTail, Params params){
        this.params = params;
        int lenOfMap = convertToNum(x,y);
        int[] excludes = calculateExclude(x,y,snakeTail);
        return null;
    }

    private int[] calculateExclude(int[] x, int[] y, List<Snake> snakeTail){
        int[] excludes = new int[snakeTail.size()];
        for(int i=0; i<snakeTail.size(); i++){
            excludes[i] = calcExcludePos(findIndex(x,snakeTail.get(i),Axis.X), findIndex(y,snakeTail.get(i),Axis.Y),x,y);

        }
        return null;
    }

    private int calcExcludePos(int a, int b, int[] x, int[] y){
        getElemLocalization(getArrayPosition(a, x), getArrayPosition(b, y));
        return 0;
    }

    //convert input into one number representation
    private int getElemLocalization(int a, int b){
        int convert = (a*params.getPreferSize()) + b;
        return convert;
    }

    private int getArrayPosition(int a, int[] coordinate){
        for (int i=0; i<coordinate.length-1; i++){
            if(coordinate[i] == a){
                return i;
            }
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
