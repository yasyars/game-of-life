import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Scanner scan = new Scanner (System.in);
        System.out.println("Enter row number..");
        int m = scan.nextInt();

        System.out.println("\nEnter column number..");
        int n = scan.nextInt();

        System.out.println("\nWrite your initial grid..");
        Grid lifeGrid = new Grid(m,n);
        lifeGrid.populate();

        System.out.println("\nBefore a life..");
        lifeGrid.print();

        System.out.println("\nDo you want to evolve? (y/n)");
        String option = scan.next();

        while (option.equals("y")){
            System.out.println("\nAfter evolution..");
            lifeGrid.evolve();
            lifeGrid.print();
            System.out.println("\nDo you want to evolve again? (y/n)");
            option = scan.next();
        }
    }
}
