import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while(true){
            if(n<1){
                break;
            }
            else{
                System.out.print(n + " ");
                n -= 1;
            }
        }
    }
}