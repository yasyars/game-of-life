import java.util.Scanner;

public class Grid {
    private int row;
    private int column;
    private int[][] cells;

    public Grid(int row, int column){
        this.row = row;
        this.column = column;
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
                int neighbour = countNeighbour(i,k);

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

    public int countNeighbour(int i, int k){
        int neighbour = 0;

        if (i>0){
            if (k>0){
                neighbour += this.cells[i - 1][k - 1];
            }
            if (k<this.column-1){
                neighbour += this.cells[i-1][k+1];
            }
            neighbour += this.cells[i-1][k];
        }

        if (k>0){
            neighbour += this.cells[i][k-1];
        }

        if (i<this.row-1){
            if (k<this.column-1) {
                neighbour += this.cells[i+1][k+1];
            }
            if (k>0){
                neighbour += this.cells[i+1][k-1];
            }
            neighbour += this.cells[i+1][k];
        }

        if(k<this.column-1){
            neighbour += this.cells[i][k+1];
        }

        return neighbour;
    }
}
