import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        
        int length = 0;
        int cnt = 0;
        for(int i=0; i<arr.length; i++){
            arr[i] = sc.next();
            length += arr[i].length();

            if(Character.toString(arr[i].charAt(0)).equals("a")){
                cnt += 1;
            }
        }
        
        System.out.println(length + " " + cnt);
    }
}