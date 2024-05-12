import java.util.*;

public class Main {
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] A = new int[n];
        for(int i=0; i<n; i++){
            A[i] = sc.nextInt();
        }

        calc(A, m);
        System.out.println(answer);
    }

    public static void calc(int[] A, int m){
        while(true){
            answer += A[m-1];

            if(m == 1){
                return;
            }
            else{    
                if(m%2 == 1){
                    m -= 1;
                }
                else{
                    m /= 2;
                }
            }
        }
    }
}