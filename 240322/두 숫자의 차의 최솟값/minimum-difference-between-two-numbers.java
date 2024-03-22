import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }

        int min = Integer.MAX_VALUE;
        for(int i=0; i<arr.length; i++){
            int a = arr[i];
            for(int j=i+1; j<arr.length; j++){
                int b = arr[j];
                min = Math.min(min, Math.abs(a-b));
            }
        }
        System.out.println(min);
    }
}