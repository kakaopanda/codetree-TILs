import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=1; i<=n; i++){
            if(i%3 == 0 || Integer.toString(i).contains("3") || 
            Integer.toString(i).contains("6") ||
            Integer.toString(i).contains("9")){
                System.out.print("0 ");
            }
            else{
                System.out.print(i + " ");
            }
        }
    }
}