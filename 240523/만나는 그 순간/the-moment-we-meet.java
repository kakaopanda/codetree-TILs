import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] A = new int[n];
        int[] B = new int[m];

        int time = 0;
        int answer = -1;

        for(int i=0; i<n; i++){
            String dir = sc.next();
            int move = sc.nextInt();
            time += move;

            if(dir.equals("L")){
                move *= -1;
            }
            A[i] = move;
        }

        for(int i=0; i<m; i++){
            String dir = sc.next();
            int move = sc.nextInt();

            if(dir.equals("L")){
                move *= -1;
            }
            B[i] = move;
        }

        int indexA = 0;
        int indexB = 0;
        int[] timeA = new int[time+1];
        int[] timeB = new int[time+1];

        for(int i=1; i<=time; i++){
            if(A[indexA] > 0){
                timeA[i] = timeA[i-1] + 1;
                A[indexA] -= 1;
                if(A[indexA] == 0){
                    indexA += 1;
                }
            }
            else if(A[indexA] < 0){
                timeA[i] = timeA[i-1] - 1;
                A[indexA] += 1;
                if(A[indexA] == 0){
                    indexA += 1;
                }
            }

            if(B[indexB] > 0){
                timeB[i] = timeB[i-1] + 1;
                B[indexB] -= 1;
                if(B[indexB] == 0){
                    indexB += 1;
                }
            }
            else if(B[indexB] < 0){
                timeB[i] = timeB[i-1] - 1;
                B[indexB] += 1;
                if(B[indexB] == 0){
                    indexB += 1;
                }
            }

            if(timeA[i] == timeB[i]){
                answer = i;
                break;
            }
        }

        System.out.println(answer);
    }
}