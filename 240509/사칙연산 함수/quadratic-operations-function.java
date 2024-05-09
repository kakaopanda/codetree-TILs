import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        String o = sc.next();
        int c = sc.nextInt();

        switch(o){
            case "+":
                plus(a, c);
                break;
            case "-":
                minus(a, c);
                break;
            case "/":
                division(a, c);
                break;
            case "*":
                multiple(a, c);
                break;
            default:
                System.out.println("False");
        }
    }

    public static void plus(int a, int c){
        int result = a + c;
        System.out.println(a + " + " + c + " = " + result);
    }

    public static void minus(int a, int c){
        int result = a - c;
        System.out.println(a + " - " + c + " = " + result);
    }

    public static void division(int a, int c){
        int result = a / c;
        System.out.println(a + " / " + c + " = " + result);
    }

    public static void multiple(int a, int c){
        int result = a * c;
        System.out.println(a + " * " + c + " = " + result);
    }
}