import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int h = sc.nextInt();
        int t = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }

        int min = Integer.MAX_VALUE;
        for(int i=0; i<arr.length-t; i++){
            int sum = 0;
            for(int j=i; j<i+t; j++){
                if(h >= arr[j]){
                    sum += h - arr[j];
                }
                else if(h < arr[j]){
                    sum += arr[j] - h;
                }
            }
            min = Math.min(min, sum);
        }

        System.out.println(min);
    }
}