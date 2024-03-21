import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        int n = sc.nextInt();

        for(int i=0; i<n; i++){
            int k = sc.nextInt();
            arr[k]++;
        }

        for(int i=1; i<10; i++){
            System.out.println(arr[i]);
        }
    }
}