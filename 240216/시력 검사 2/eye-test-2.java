import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double eye = sc.nextDouble();

        if(eye >= 1.0){
            System.out.println("High");
        }
        else if(eye >= 0.5){
            System.out.println("Middle");
        }
        else{
            System.out.println("Low");
        }
    }
}