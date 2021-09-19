import java.util.Scanner;

public class Main {
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
    }
}
