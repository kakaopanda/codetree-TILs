import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] A = new int[1000001];
        int[] B = new int[1000001];

        int time = 0;
        int indexA = 1;
        int indexB = 1;
        for(int i=1; i<=n; i++){
            int v = sc.nextInt();
            int t = sc.nextInt();
            time += t;

            while(t > 0){
                A[indexA] = A[indexA-1] + v;
                t -= 1;
                indexA += 1;
            }
        }

        for(int i=1; i<=m; i++){
            int v = sc.nextInt();
            int t = sc.nextInt();

            while(t > 0){
                B[indexB] = B[indexB-1] + v;
                t -= 1;
                indexB += 1;
            }
        }

        int cnt = 0;
        String rank = "Empty";
        for(int i=1; i<=time; i++){
            if(rank.equals("Empty")){
                if(A[i] > B[i]){
                    rank = "A";
                    cnt += 1;
                }
                else if(A[i] < B[i]){
                    rank = "B";
                    cnt += 1;
                }
                else if(A[i] == B[i]){
                    rank = "AB";
                    cnt += 1;
                }
            }
            else if(rank.equals("AB")){
                if(A[i] > B[i]){
                    rank = "A";
                    cnt += 1;
                }
                else if(A[i] < B[i]){
                    rank = "B";
                    cnt += 1;
                }
            }
            else if(rank.equals("A")){
                if(A[i] < B[i]){
                    rank = "B";
                    cnt += 1;
                }
                else if(A[i] == B[i]){
                    rank = "AB";
                    cnt += 1;
                }
            }
            else if(rank.equals("B")){
                if(A[i] > B[i]){
                    rank = "A";
                    cnt += 1;
                }
                else if(A[i] == B[i]){
                    rank = "AB";
                    cnt += 1;
                }
            }
        }

        System.out.println(cnt);
    }
}