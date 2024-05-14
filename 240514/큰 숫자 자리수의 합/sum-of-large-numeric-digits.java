import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int mul = 1;
        for(int i=0; i<3; i++){
            mul *= sc.nextInt();
        }

        System.out.println(sum(mul));
    }

    public static int sum(int n){
        if(n < 10){
            return n%10;
        }
        else{
            return sum(n/10) + n%10;
        }
    }
}