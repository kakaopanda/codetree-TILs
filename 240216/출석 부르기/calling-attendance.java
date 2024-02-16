import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String name = "";

        if(n==1){
            name = "John";
        }
        else if(n==2){
            name = "Tom";
        }
        else if(n==3){
            name = "Paul";
        }
        else{
            name = "Vacancy";
        }
        System.out.println(name);
    }
}