import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = 0;

        while(true){
            if(cnt == 3){
                break;
            }
            int n = sc.nextInt();

            if(n%2 == 1){
                continue;
            }
            else{
                System.out.println(n/2);
                cnt += 1;
            }
        }
    }
}