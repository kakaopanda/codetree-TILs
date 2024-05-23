import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] A = new int[1000001];
        int[] B = new int[1000001];

        int timeA = 1;
        int timeB = 1;
        for(int i=0; i<n; i++){
            int move = sc.nextInt();
            String dir = sc.next();
            int op = dir.equals("L") ? -1 : 1;

            while(move > 0){
                A[timeA] = A[timeA-1] + op;
                timeA += 1;
                move -= 1;
            }
        }

        for(int i=0; i<m; i++){
            int move = sc.nextInt();
            String dir = sc.next();
            int op = dir.equals("L") ? -1 : 1;

            while(move > 0){
                B[timeB] = B[timeB-1] + op;
                timeB += 1;
                move -= 1;
            }
        }

        // 더 긴 수행시간을 가진 쪽을 기준으로, 나머지 시간대를 최종 위치로 갱신해준다.
        if(timeA < timeB){
            for(int i=timeA; i<timeB; i++){
                A[i] = A[timeA-1];
            }
        }
        else{
            for(int i=timeB; i<timeA; i++){
                B[i] = B[timeB-1];
            }
        } 

        int time = Math.max(timeA, timeB);
        int cnt = 0;
        for(int i=1; i<time; i++){
            if(A[i-1] != B[i-1]){
                if(A[i] == B[i]){
                    cnt += 1;
                }
            }
        }

        System.out.println(cnt);
    }
}