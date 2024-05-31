import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[3];

        for(int i=0; i<3; i++){
            arr[i] = sc.nextInt();
        }

        // 9^3 = 729가지 경우의 수 고려(중복순열)
        // (1,1,1) ~ (9,9,9) 
        int cnt = 0;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                for(int k=1; k<=n; k++){
                    if(Math.abs(arr[0]-i)<=2 || Math.abs(arr[1]-j)<=2 || Math.abs(arr[2]-k)<=2){
                         cnt += 1;
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}