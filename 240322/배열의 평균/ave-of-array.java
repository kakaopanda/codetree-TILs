import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] arr = new double[2][4];
        double[] rowAvg = new double[2];
        double[] colAvg = new double[4];
        double totAvg = 0;

        for(int i=0; i<2; i++){
            for(int j=0; j<4; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        for(int i=0; i<2; i++){
            for(int j=0; j<4; j++){
                rowAvg[i] += arr[i][j];
                colAvg[j] += arr[i][j];
                totAvg += arr[i][j];
            }
        }

        for(int i=0; i<2; i++){
            System.out.print(rowAvg[i]/4 + " ");
        }
        System.out.println();

        for(int i=0; i<4; i++){
            System.out.print(colAvg[i]/2 + " ");
        }
        System.out.println();

        System.out.println(totAvg/8);
    }
}