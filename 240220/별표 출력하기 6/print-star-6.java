import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int cnt = 0;
        for(int i=2*n-1; i>0; i-=2, cnt+=1){
            for(int j=cnt; j>0; j--){
                System.out.print("  ");
            }
            for(int j=i; j>0; j--){
                System.out.print("* ");
            }
            System.out.println();
        }

        cnt = 1;
        for(int i=n-1; i>0; i--, cnt+=1){
            for(int j=i-1; j>0; j--){
                System.out.print("  ");
            }
            for(int j=2*cnt+1; j>0; j--){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}