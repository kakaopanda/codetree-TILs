import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        int[] B = new int[n];

        for(int i=0; i<A.length; i++){
            A[i] = sc.nextInt();
        }
        Arrays.sort(A);

        for(int i=0; i<B.length; i++){
            B[i] = sc.nextInt();
        }
        Arrays.sort(B);

        boolean equal = true;
        for(int i=0; i<A.length; i++){
            if(A[i] != B[i]){
                equal = false;
                break;
            }
        }

        if(equal){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }
}