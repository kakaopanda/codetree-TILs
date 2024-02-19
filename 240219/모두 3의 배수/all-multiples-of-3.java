import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean check = true;

        for(int i=0; i<5; i++){
            int n = sc.nextInt();
            if(n%3 == 0){
                continue;
            }
            else{
                check = false;
                break;
            }
        }
        if(check){
            System.out.println("1");
        }
        else{
            System.out.println("0");
        }
    }
}