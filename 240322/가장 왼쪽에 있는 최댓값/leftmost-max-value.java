import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        int nextIndex = n;
        while(true){
            int max = Integer.MIN_VALUE;
            
            if(nextIndex == 0){
                break;
            }

            int index = 0;
            for(int i=0; i<nextIndex; i++){
                if(arr[i] > max){
                    index = i;
                    max = arr[i];
                }
            }
            System.out.print(index+1 + " ");
            nextIndex = index;
        }
        
    }
}