import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int cnt = 0;
        for(int i=0; i<n; i++){
            if(m == sc.nextInt()){
                cnt += 1;
            }
        }
        System.out.println(cnt);
    }
}