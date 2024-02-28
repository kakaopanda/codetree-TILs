import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int cnt = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<i+1; j++){
                if(cnt > 'Z'-'A'){
                    cnt = 0;
                }
                System.out.print((char)('A' + cnt++));
            }
            System.out.println();
        }
    }
}