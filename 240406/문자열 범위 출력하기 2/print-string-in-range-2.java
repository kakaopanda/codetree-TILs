import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] arr = s.toCharArray();
        int n = sc.nextInt();

        if(n > arr.length){
            n = arr.length;
        }
        for(int i=arr.length-1; i>=arr.length-n; i--){
            System.out.print(arr[i]);
        }
    }
}