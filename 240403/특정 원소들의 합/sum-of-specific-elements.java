import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[4][4];

        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        int sum = 0;
        for(int i=0; i<arr.length; i++){
            for(int j=i; j<arr[i].length; j++){
                sum += arr[j][i];
            }
        }
        System.out.println(sum);
    }
}