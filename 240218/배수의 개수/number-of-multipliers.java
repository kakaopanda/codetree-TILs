import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cntThree = 0;
        int cntFive = 0;

        for(int i=0; i<10; i++){
            int n = sc.nextInt();
            if(n%3==0 && n%5==0){
                cntThree += 1;
                cntFive += 1;
            }
            else if(n%3 == 0){
                cntThree += 1;
            }
            else if(n%5 == 0){
                cntFive += 1;
            }
        }
        System.out.println(cntThree + " " + cntFive);
    }
}