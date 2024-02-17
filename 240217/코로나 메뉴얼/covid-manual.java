import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] cold = new String[3];
        int[] temp = new int[3];
        int cnt = 0;

        for(int i=0; i<3; i++){
           cold[i] = sc.next();
           temp[i] = sc.nextInt();
        }

        for(int i=0; i<3; i++){
            if(cold[i].equals("Y") && temp[i]>=37){
                cnt += 1;
            }
        }
        
        if(cnt >= 2){
            System.out.println("E");
        }
        else{
            System.out.println("N");
        }
    }
}