package best.programming;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Random random = new Random();

        int arraySize = random.nextInt(11) + 10;
        int [][] array = new int[arraySize][arraySize];

        for(int i = 0; i < arraySize; i++){
            for(int j = 0; j < arraySize; j++){
                if(i == j){
                    boolean element = random.nextBoolean();
                    if(element){
                        array[i][j] = 1;
                    } else {
                        array[i][j] = -1;
                    }
                } else {
                    int element = random.nextInt(201) - 100;
                    array[i][j] = element;
                }
            }
        }

        for(int i = 0; i < arraySize; i++) {
            for (int j = 0; j < arraySize; j++) {
                System.out.print(" " + array[i][j]);
            }
            System.out.println();
        }


    }
}
