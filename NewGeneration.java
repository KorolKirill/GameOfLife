package life;

public class NewGeneration {
    static int len;

    public String[][] makeNewGeneration(String[][] givenUniverse) {
        len = givenUniverse.length;
        String[][] nextGeneration = new String[len][len];

        for (int x = 0; x < len ; x++) {
            for (int k = 0; k < len; k++) {
                int neighbours = neighbourScore(x,k,givenUniverse);
                if ( ( neighbours==2 || neighbours==3 ) && givenUniverse[x][k].equals("O") )  {
                    nextGeneration[x][k] = "O";
                }
                else if (neighbours==3 && givenUniverse[x][k].equals(" ")) {
                    nextGeneration[x][k] = "O";
                }
                else {
                    nextGeneration[x][k] = " ";
                }

            }
        }
        return nextGeneration;
    }

    int neighbourScore (int coordinateX,int coordinateK,String[][] givenUniverse) {
        int neighbour = 0;
        for (int i = -1; i < 2; i++) {
            for (int p = -1; p < 2; p++) {
                if (i==0 && p==0) {
                    continue;
                }
                if (givenUniverse[calibratesCoordinate(i+coordinateX)][calibratesCoordinate(p+coordinateK)].equals("O")) {
                    neighbour++;
                }

            }
        }
        return neighbour;
    }
    int calibratesCoordinate (int coordinate){
        if (coordinate < 0) {
                coordinate = len - 1;
            }
        else if (coordinate == len) {
            coordinate = 0;
        }
        return coordinate;
    }
}
