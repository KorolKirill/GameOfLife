package life;

public class Printer implements Print  {
    public void print(String[][] matrix) {
        for (String[] k : matrix) {
            for (String i : k) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
