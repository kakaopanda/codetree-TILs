import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String a = sc.next();
        char[] arr = a.toCharArray();

        char start = a.charAt(0);
        int cnt = 1;
        for(int i=1; i<arr.length; i++){
            if(start == arr[i]){
                cnt += 1;
            }
            else{
                sb.append(start);
                sb.append(cnt);
                start = arr[i];
                cnt = 1;
            }
        }
        sb.append(start);
        sb.append(cnt);

        System.out.println(sb.length());
        System.out.println(sb);
    }
}