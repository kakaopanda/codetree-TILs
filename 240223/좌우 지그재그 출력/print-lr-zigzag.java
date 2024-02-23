import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int cnt = 1;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i%2 == 0){
                    System.out.print(cnt + " ");
                    if(j!=n-1){
                        cnt += 1;
                    }
                }
                else{
                    System.out.print(cnt + " ");
                    if(j!=n-1){
                        cnt -= 1;
                    }
                }
                if(j==n-1){
                    cnt += n;
                }
            }
            System.out.println();
        }
    }
}