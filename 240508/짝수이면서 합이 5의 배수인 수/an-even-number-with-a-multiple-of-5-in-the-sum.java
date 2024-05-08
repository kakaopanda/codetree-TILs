import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if(isTargetNumber(n)){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }

    public static boolean isTargetNumber(int n){
        if(n%2 == 0){
            if((n/10 + n%10)%5 == 0){
                return true;
            }
        }
        
        return false;   
    }
}