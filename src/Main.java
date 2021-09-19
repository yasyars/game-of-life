import java.util.Scanner;

public class Main {
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

    public static void printMatrix(int[][] matrix){
        int m= matrix.length;
        int n= matrix[0].length;
        for (int i=0;i<m; i++){
            for (int k=0; k<n; k++){
                System.out.print(matrix[i][k] + " ");
            }
            System.out.print("\n");
        }
    }

    public static void main(String args[]){
        Scanner scan = new Scanner (System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();

        int[][] matrix = new int[m][n];
        for (int i=0; i<m; i++){
            int[] array = new int[n];
            for (int k=0; k<n; k++){
                array[k] = scan.nextInt();
            }
            matrix[i] = array;
        }

        System.out.println("\nBefore a life..");
        printMatrix(matrix);

        System.out.println("\nAfter a life..");
        printMatrix(afterLife(matrix));

    }
}
