import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        int sum = n1 + n2;
        String s = Integer.toString(sum);

        int cnt = 0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '1'){
                cnt += 1;
            }
        }
        System.out.println(cnt);
    }
}