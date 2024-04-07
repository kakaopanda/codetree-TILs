import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // (1,1) ~ (19,19) -> (0,0) ~ (18, 18)
        int[][] arr = new int[19][19];
        int answer = 0;
        int R = 0;
        int C = 0;

        for(int i=0; i<19; i++){
            for(int j=0; j<19; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        STOP:
        for(int i=0; i<19-4; i++){
            for(int j=0; j<19-4; j++){
                if(arr[i][j] != 0){
                    int v = arr[i][j];

                    // 1. 세로로 연속되는지 확인
                    if(i-4>=0 && arr[i-1][j]==v && arr[i-2][j]==v &&
                    arr[i-3][j]==v && arr[i-4][j]==v){
                        R = i-2+1;
                        C = j+1;
                        answer = v;
                        break STOP;
                    }

                    // 2. 가로로 연속되는지 확인
                    if(j-4>=0 && arr[i][j-1]==v && arr[i][j-2]==v &&
                    arr[i][j-3]==v && arr[i][j-4]==v){
                        R = i+1;
                        C = j-2+1;
                        answer = v;
                        break STOP;
                    }

                    // 3. 대각선으로 연속되는지 확인
                    if(i-4>=0 && j-4>=0 && arr[i-1][j-1]==v && arr[i-2][j-2]==v &&
                    arr[i-3][j-3]==v && arr[i-4][j-4]==v){
                        R = i-2+1;
                        C = j-2+1;
                        answer = v;
                        break STOP;
                    }
                }
            }
        }
       
        // 승리여부 출력
        System.out.println(answer);

        // 가운데 위치한 바둑알의 가로줄 및 세로줄 번호 출력(세로,가로,대각선)
        System.out.println(R + " " + C);
    }
}