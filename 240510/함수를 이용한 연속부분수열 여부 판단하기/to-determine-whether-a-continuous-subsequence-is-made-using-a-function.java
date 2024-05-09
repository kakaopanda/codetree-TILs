import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        int[] A = new int[n1];
        int[] B = new int[n2];

        for(int i=0; i<n1; i++){
            A[i] = sc.nextInt();
        }

        for(int i=0; i<n2; i++){
            B[i] = sc.nextInt();
        }

        if(isSubArray(A, B)){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }

    public static boolean isSubArray(int[] A, int[] B){
        for(int i=0; i<=A.length-B.length; i++){
            if(A[i] == B[0]){
                for(int j=1; j<B.length; j++){
                    if(B[j] == A[i+j]){
                        if(j == B.length-1){
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }
}