import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=2*n+1; i>0; i--){
            if(i%2 == 1){
                for(int j=2*n+1; j>0; j--){
                    System.out.print("* ");
                }
                System.out.println();
            }
            else{
                for(int j=n+1; j>0; j--){
                    System.out.print("*   ");
                }
                System.out.println();
            }
        }
    }
}