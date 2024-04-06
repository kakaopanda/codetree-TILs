import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = "";

        for(int i=0; i<n; i++){
            s += sc.next();
        }
        char[] arr = s.toCharArray();

        for(int i=0; i<arr.length; i++){
            if((i+1)%5 == 0){
                System.out.println(arr[i]);
            }
            else{
                System.out.print(arr[i]);
            }
        }
    }
}