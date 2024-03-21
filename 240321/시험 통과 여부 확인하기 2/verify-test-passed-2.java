import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int cnt = 0;
        for(int i=0; i<n; i++){
            int sum = 0; 
            for(int j=0; j<4; j++){
                sum += sc.nextInt();
            }
            if(sum/4 >= 60){
                cnt += 1;
                System.out.println("pass");
            }
            else{
                System.out.println("fail");
            }
        }
        System.out.println(cnt);
    }
}