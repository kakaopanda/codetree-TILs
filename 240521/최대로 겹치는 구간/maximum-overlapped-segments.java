import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[200];

        for(int i=0; i<n; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            for(int j=start; j<end; j++){
                arr[j] += 1;
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            max = Math.max(max, arr[i]);
        }

        System.out.println(max);
    }
}