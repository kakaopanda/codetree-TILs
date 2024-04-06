import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        int cnt = 0;
        double avg = 0;

        for(int i=0; i<n; i++){
            arr[i] = sc.next();
        }
        String s = sc.next();

        for(int i=0; i<n; i++){
            if(Character.toString(arr[i].charAt(0)).equals(s)){
                cnt += 1;
                avg += arr[i].length();
            }
        }

        System.out.printf("%d %.2f", cnt, avg/cnt);
    }
}