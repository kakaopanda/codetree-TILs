import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<10; i++){
            arr[i] = sc.nextInt();
        }
        for(int i=0; i<10; i++){
            if(arr[i] < 500){
                max = Math.max(max, arr[i]);
            }
            else if(arr[i] > 500){
                min = Math.min(min, arr[i]);
            }
        }

        System.out.println(max + " " + min);
    }
}