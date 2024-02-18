import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int cnt = 0;

        while(true){
            int n = sc.nextInt();
            if(n>=20 && n<=29){
                sum += n;
                cnt += 1;
            }
            else{
                break;
            }
        }
        System.out.printf("%.2f", (double)sum/cnt);
    }
}