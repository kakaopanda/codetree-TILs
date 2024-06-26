import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[101];
        
        for(int i=0; i<n; i++){
            int candy = sc.nextInt();
            int index = sc.nextInt();
            arr[index] += candy;
        }

        int max = Integer.MIN_VALUE;
        
        if(k >= arr.length/2-1){
            int sum = 0;
            for(int i=0; i<arr.length; i++){
                sum += arr[i];
            }
            max = Math.max(max, sum);
        }
        else{
            for(int i=k; i<arr.length-k-1; i++){
                int sum = 0;
                for(int j=i-k; j<=i+k; j++){
                    sum += arr[j];
                }
                max = Math.max(max, sum);
            }
        }
        
        System.out.println(max);
    }
}