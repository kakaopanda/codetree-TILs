import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];

        for(int i=0; i<arr.length; i++){
            arr[i] = sc.next();
        }
        Arrays.sort(arr);
        
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}