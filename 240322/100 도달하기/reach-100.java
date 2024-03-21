import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[2];

        arr[0] = 1;
        arr[1] = n;

        System.out.print(arr[0] + " " + arr[1] + " ");
        while(true){
            int k = arr[0] + arr[1];
            arr[0] = arr[1];
            arr[1] = k;

            System.out.print(k + " ");
            if(k > 100){
                break;
            }
        }
    }
}