import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=1; i<=n; i++){
            if(i%2 == 1){
                System.out.println("*");
            }
            else{
                for(int j=i; j>0; j--){
                    System.out.print("* ");
                }
                System.out.println();
            }
        }
    }
}