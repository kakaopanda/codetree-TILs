import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        Speed[] A = new Speed[n];
        Speed[] B = new Speed[m];

        int time = 0;
        for(int i=0; i<n; i++){
            int v = sc.nextInt();
            int t = sc.nextInt();
            A[i] = new Speed(v, t);

            time += t;
        }

        for(int i=0; i<m; i++){
            int v = sc.nextInt();
            int t = sc.nextInt();
            B[i] = new Speed(v, t);
        }

        int[] timeA = new int[time+1];
        int[] timeB = new int[time+1];
        int indexA = 0;
        int indexB = 0;
        String winner = "Empty";

        int cnt = 0;
        for(int i=1; i<=time; i++){
            timeA[i] += timeA[i-1] + A[indexA].speed;
            A[indexA].time -= 1;

            if(A[indexA].time == 0){
                indexA += 1;
            }

            timeB[i] += timeB[i-1] + B[indexB].speed;
            B[indexB].time -= 1;

            if(B[indexB].time == 0){
                indexB += 1;
            }

            if(winner.equals("Empty")){
                if(timeA[i] > timeB[i]){
                    winner = "A";
                }
                else if(timeA[i] < timeB[i]){
                    winner = "B";
                }
            }
            else{
                if(timeA[i] > timeB[i]){
                    if(winner.equals("A")){
                        continue;
                    }
                    else{
                        cnt += 1;
                        winner = "A";
                    }
                }
                else if(timeA[i] < timeB[i]){
                    if(winner.equals("B")){
                        continue;
                    }
                    else{
                        cnt += 1;
                        winner = "B";
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}

class Speed{
    int speed;
    int time;

    public Speed(int s, int t){
        speed = s;
        time = t;
    }
}