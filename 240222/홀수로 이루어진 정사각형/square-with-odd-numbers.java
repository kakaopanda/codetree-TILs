import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int k = 11;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(k + i*2 + j*2 + " ");
            }
            System.out.println();
        }
    }
}