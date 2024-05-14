import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[2*n];

        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length/2; i++){
            int sum = arr[i] + arr[arr.length-i-1];
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }
}