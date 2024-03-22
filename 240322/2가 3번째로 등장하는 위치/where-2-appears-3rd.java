import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        int cnt = 0;
        int index = -1;
        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
            if(arr[i] == 2){
                cnt += 1;
                if(cnt == 3){
                    index = i;
                    break;
                }
            }
        }
        System.out.println(index+1);    
    }
}