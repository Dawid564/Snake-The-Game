package com.snake.engine;

import com.snake.dao.Params;
import com.snake.dao.Snake;

import java.util.List;
import java.util.Random;


public class SnakeFood {

    private Random rand = new Random();
    private enum Axis{X,Y}
    private Params params;

    public void setUpParams(Params params){
        this.params = params;
    }

    public int[] initFood(int[] x, int[] y, List<Snake> snakeTail){
        int[] coordinates = calculateExclude(x,y,snakeTail);
        return corrector(coordinates);
    }

    private int[] corrector(int[] testData){
        for (int i=0; i<2; i++){
            if(testData[0] == -1){
                testData[0] = 0;
            }
            if(testData[1] == -1){
                testData[1] = 0;
            }
            if(testData[0] == 21){
                testData[0] = 20;
            }
            if(testData[1] == 21){
                testData[1] = 20;
            }
        }
        return testData;
    }

    private int[] calculateExclude(int[] x, int[] y, List<Snake> snakeTail){
        int[] excludes = new int[snakeTail.size()];
        for(int i=0; i<snakeTail.size(); i++){
            excludes[i] = calcExcludePos(findIndex(x,snakeTail.get(i),Axis.X), findIndex(y,snakeTail.get(i),Axis.Y),x,y);

        }

        //random choose with exclude list
        return getCoordinate(excludes); //
    }

    private int[] getCoordinate(int[] excludes){
        int food = nextIntExclude(params.getPreferSize()*params.getPreferSize(), excludes);
        return convertIntIntoCoord(food);
    }

    //return coordinate representation of food
    private int[] convertIntIntoCoord(int food){
        int y = 0;
        int x;
        for(int i=0; i<400; i = i + 20){
            if(i<food){
                y = i;
            }
        }
        x = (food - y) - 1;
        y = (y/20) - 1;
        System.out.println("right y " + y);
        System.out.println("right x " + x);
        int[] coordinates = new int[2];
        coordinates[0] = x;
        coordinates[1] = y;
        return coordinates;
    }

    private int nextIntExclude(int end, int... excludes){
        int randomInt = this.rand.nextInt(end);
        boolean looking = false;
        while(true){
            for(int i=0; i<excludes.length; i++){
                if(excludes[i] == randomInt){
                    looking = true;
                }
            }
            //if found duplicate in excludes
            if(looking){
                randomInt = this.rand.nextInt(end);
            }else{
                return randomInt;
            }
        }
    }

    private int calcExcludePos(int a, int b, int[] x, int[] y){
        return getElemLocalization(getArrayPosition(a, x), getArrayPosition(b, y));
    }

    //convert input into one number representation
    private int getElemLocalization(int a, int b){
        int convert = (b*params.getPreferSize()) + a;
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
