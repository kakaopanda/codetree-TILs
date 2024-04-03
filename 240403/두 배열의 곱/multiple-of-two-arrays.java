import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arrA = new int[3][3];
        int[][] arrB = new int[3][3];

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                arrA[i][j] = sc.nextInt();
            }
        }

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                arrB[i][j] = sc.nextInt();
            }
        }

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                System.out.print(arrA[i][j] * arrB[i][j] + " ");
            }
            System.out.println();
        }
    }
}