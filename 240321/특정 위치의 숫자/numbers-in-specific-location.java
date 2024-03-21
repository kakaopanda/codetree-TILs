import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        for(int i=0; i<10; i++){
            if(i==2 || i==4 || i==9){
                sum += sc.nextInt();
            }
            else{
                sc.nextInt();
            }
        }
        System.out.println(sum);
    }
}