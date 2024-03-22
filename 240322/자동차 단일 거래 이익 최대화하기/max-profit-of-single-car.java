import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        int max = 0;
        for(int i=0; i<n; i++){
            int start = arr[i];

            for(int j=i+1; j<n; j++){
                int end = arr[j];
                if(end > start){
                    max = Math.max(max, end-start);
                }
            }
        }
        System.out.println(max);
    }
}