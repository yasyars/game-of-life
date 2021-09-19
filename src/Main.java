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

    public void populateWithArray(int[][] newCells){
        for (int i=0; i<this.row; i++){
            for (int k=0; k<this.column; k++){
                this.cells[i][k]= newCells[i][k];
            }
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

    public void evolve(){
        int[][] newCells = new int[this.row][this.column];

        for (int i=0;i<this.row; i++){
            for (int k=0; k<this.column; k++){
                int neighbour = 0;
                if (i>0 && k>0) {
                    neighbour += this.cells[i - 1][k - 1];
                }

                if (i<this.row-1 && k<this.column-1) {
                    neighbour += this.cells[i+1][k+1];
                }

                if (i>0 && k<this.column-1){
                    neighbour += this.cells[i-1][k+1];
                }

                if (i<this.row-1 && k>0){
                    neighbour += this.cells[i+1][k-1];
                }

                if (i>0){
                    neighbour += this.cells[i-1][k];
                }
                if (k>0){
                    neighbour += this.cells[i][k-1];
                }
                if (i<this.row-1){
                    neighbour += this.cells[i+1][k];
                }
                if(k<this.column-1){
                    neighbour += this.cells[i][k+1];
                }

                if (neighbour<2 || neighbour>3){
                    newCells[i][k]=0;
                }else if (neighbour==3){
                    newCells[i][k]=1;
                }else{//if 2
                    newCells[i][k]= this.cells[i][k];
                }
            }
        }
        populateWithArray(newCells);
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
        lifeGrid.evolve();
        lifeGrid.print();

    }
}
