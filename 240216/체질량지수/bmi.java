import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int height = sc.nextInt();
        int weight = sc.nextInt();
        double cal = (weight / (double)Math.pow((double)height/100, 2));

        System.out.println((int)cal);
        if(cal >= 25){
            System.out.println("Obesity");
        }
    }
}