package life;

import java.io.IOException;

public class Functionality {
    private final Print printer;
    private final firsMatrix firsMatrix;
    private final int matrixSize;
    private String[][] universe;
    NewGeneration generator = new NewGeneration();
    public Functionality(Print print, life.firsMatrix firsMatrix,int matrixSize) {
        this.printer = print;
        this.firsMatrix = firsMatrix;
        this.matrixSize = matrixSize;
        makeMatrix();

    }

    public void nextGeneration() {
        universe = generator.makeNewGeneration(universe);
    }

    public int getMatrixSize() {
        return matrixSize;
    }

    public String[][] getUniverse() {
        return universe;
    }

    public  void makeMatrix() {
         universe =  firsMatrix.makeMatrix(matrixSize);
    }

    public int counterAlive() {
     int alive = 0;
     for (String[] rows : universe) {
         for (String element : rows) {
             if ("O".equals(element)) {
                 alive++;
             }
         }
     }
        return alive;
    }

    @Deprecated
    public void print(String[][] matrix) {
        printer.print(matrix);
    }
}
