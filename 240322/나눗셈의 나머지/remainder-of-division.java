import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int[] arr = new int[10];
        
        while(true){
            if(a<=1){
                break;
            }
            else{
                arr[a%b]++;
                a = a/b;
            }
        }

        int sum = 0;
        for(int i=0; i<arr.length; i++){
            sum += Math.pow(arr[i],2);
        }
        System.out.println(sum);
    }
}