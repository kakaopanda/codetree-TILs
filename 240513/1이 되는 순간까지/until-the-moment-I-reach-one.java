import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(division(n, 0));
    }

    public static int division(int n, int cnt){
        if(n == 1){
            return cnt;
        }
        else{
            if(n%2 == 0){
                return division(n/2, cnt+1);
            }
            else{
                return division(n/3, cnt+1);
            }
        }
    }
}