import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        
        for(int i=0; i<100; i++){
            int n = sc.nextInt();
            arr[n/10]++;

            if(n == 0){
                break;
            }
        }

        for(int i=1; i<10; i++){
            System.out.println(i + " - " + arr[i]);
        }
    }
}