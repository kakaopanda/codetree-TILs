import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;

        for(int i=1; i<=n; i++){
            if(i%4 == 0){
                if(i%100==0 && i%400!=0){
                    continue;
                }
                else{
                    cnt += 1;
                }
            }
        }
        System.out.println(cnt);
    }
}