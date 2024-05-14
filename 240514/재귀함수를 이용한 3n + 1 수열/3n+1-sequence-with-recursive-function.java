import java.util.*;

public class Main {
    static int cnt = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(calc(n));
    }

    public static int calc(int n){
        if(n == 1){
            return cnt;
        }
        else{
            cnt += 1;
            if(n%2 == 0){
                return calc(n/2);
            }
            else{
                return calc(n*3 + 1);
            }
        }
    }
}