import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int cnt = 1;
        for(int i=n; i>0; i--){
            for(int j=n; j>0; j--){
                if(cnt > 9){
                    cnt = 1;
                }
                
                if(j <= i){
                    System.out.print(cnt++ + " ");
                }
                else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}