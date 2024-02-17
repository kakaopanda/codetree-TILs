import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sex = sc.nextInt();
        int age = sc.nextInt();
        String category = "";

        if(sex == 0){
            if(age >= 19){
                category = "MAN";
            }
            else{
                category = "BOY";
            }   
        }
        else if(sex == 1){
            if(age >= 19){
                category = "WOMAN";
            }
            else{
                category = "GIRL";
            }
        }
        System.out.println(category);
    }
}