import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cntClassroom = 0;
        int cntCorridor = 0;
        int cntToilet = 0;

        for(int i=1; i<=n; i++){
            if(i%12 == 0){
                cntToilet += 1;
            }
            else if(i%3 == 0){
                cntCorridor += 1;
            }
            else if(i%2 == 0){
                cntClassroom += 1;
            }
        }
        System.out.print(cntClassroom + " " + cntCorridor + " " + cntToilet);
    }
}