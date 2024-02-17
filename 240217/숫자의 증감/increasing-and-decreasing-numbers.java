import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = sc.nextInt();

        if(s.equals("A")){
            for(int i=1; i<=n; i++){
                System.out.print(i + " ");
            }
        }
        else if(s.equals("D")){
            for(int i=n; i>=1; i--){
                System.out.print(i + " ");
            }
        }
    }
}