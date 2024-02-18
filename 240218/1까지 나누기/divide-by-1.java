import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;

        int i = 1;
        while(true){
            if(n<=1){
                break;
            }
            else{
                n /= i;
                i += 1;
                cnt += 1;
            }
        }
        System.out.println(cnt);
    }
}