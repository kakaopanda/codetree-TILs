import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = 3;

        while(true){
            if(i>n){
                break;
            }
            else{
                if(i%3 == 0){
                    System.out.print(i + " ");
                }
                i += 3;
            }
        }
        
    }
}