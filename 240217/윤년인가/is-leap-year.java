import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();

        if(y%4 == 0){
            if(y%100 == 0){
                System.out.println("false");
                if(y%400 == 0){
                    System.out.println("true");
                }
            }
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }      
    }
}