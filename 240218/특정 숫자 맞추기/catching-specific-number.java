import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while(true){
            int n = sc.nextInt();
            if(n == 25){
                System.out.println("Good");
                break;
            }
            else if(n > 25){
                System.out.println("Lower");
            }
            else if(n < 25){
                System.out.println("Higher");
            }
        }
    }
}