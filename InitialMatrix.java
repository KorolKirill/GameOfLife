package life;

import java.util.Random;

public class InitialMatrix implements firsMatrix {
    public String[][] makeMatrix(int matrixSize) {
        Random random = new Random();
        String[][] matrix = new String[matrixSize][matrixSize];

        for (int i = 0 ; i < matrix.length; i++) {
            for (int k =0; k< matrix[i].length ; k++) {
                if (random.nextBoolean()) {
                    matrix[i][k] ="O";
                }
                else {
                    matrix[i][k] =" ";
                }
            }
        }
        return matrix;
    }
}
