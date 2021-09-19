import java.util.Scanner;

class Grid{
  private int row;
  private int column;
  private int[][] cells;

  public Grid(int row, int column){
      cells = new int[row][column];
  }

  public void populate(){
      Scanner scan = new Scanner (System.in);

      for (int i=0; i<this.row; i++){
          int[] array = new int[this.column];
          for (int k=0; k<this.column; k++){
              array[k] = scan.nextInt();
          }
          this.cells[i] = array;
      }
  }

  public void print(){
    for (int i=0;i<this.row; i++){
        for (int k=0; k<this.column; k++){
            System.out.print(this.cells[i][k] + " ");
        }
        System.out.print("\n");
    }
  }

  public static int[][] afterLife(int[][] initial){
        int m= initial.length;
        int n= initial[0].length;
        int[][] newMatrix = new int[m][n];

        for (int i=0;i<m; i++){
            for (int k=0; k<n; k++){
                int neighbour = 0;
                if (i>0 && k>0) {
                    neighbour += initial[i - 1][k - 1];
                }

                if (i<m-1 && k<n-1) {
                    neighbour += initial[i+1][k+1];
                }

                if (i>0 && k<n-1){
                    neighbour += initial[i-1][k+1];
                }

                if (i<m-1 && k>0){
                    neighbour += initial[i+1][k-1];
                }

                if (i>0){
                    neighbour += initial[i-1][k];
                }
                if (k>0){
                    neighbour += initial[i][k-1];
                }
                if (i<m-1){
                    neighbour += initial[i+1][k];
                }
                if(k<n-1){
                    neighbour += initial[i][k+1];
                }

                if (neighbour<2 || neighbour>3){
                    newMatrix[i][k]=0;
                }else if (neighbour==3){
                    newMatrix[i][k]=1;
                }else{//if 2
                    newMatrix[i][k]= initial[i][k];
                }
            }
        }

        return newMatrix;
    }
}

public class Main {


    public static void main(String args[]){
        Scanner scan = new Scanner (System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();

        Grid lifeGrid = new Grid(m,n);
        lifeGrid.populate();

        System.out.println("\nBefore a life..");
        lifeGrid.print();

        System.out.println("\nAfter a life..");
        printMatrix(afterLife(matrix));

    }
}
