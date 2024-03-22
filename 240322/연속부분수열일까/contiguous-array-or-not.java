import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        int[] arrA = new int[n1];
        int[] arrB = new int[n2];

        for(int i=0; i<n1; i++){
            arrA[i] = sc.nextInt();
        }
        for(int i=0; i<n2; i++){
            arrB[i] = sc.nextInt();
        }

        for(int i=0; i<n1-n2; i++){
            if(arrB[0] == arrA[i]){
                boolean check = true;
                for(int j=1; j<n2; j++){
                    if(arrB[j] == arrA[i+j]){
                        continue;
                    }
                    else{
                        check = false;
                        break;
                    }
                }
                if(check){
                    System.out.println("Yes");
                    return;
                }
            }
        }
        System.out.println("No");
    }
}