import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        char[][] arr = new char[N][M];
        int cnt = 0;

        for(int i=0; i<N; i++){
            String s = sc.next();
            for(int j=0; j<M; j++){
                arr[i][j] = s.charAt(j);
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(arr[i][j] == 'L'){
                    // (1). 12시 방향 확인
                    if(i-2>=0 && arr[i-1][j]=='E' && arr[i-2][j]=='E'){
                        cnt += 1;
                    }
                    // (2). 1시 방향 확인
                    if(i-2>=0 && j+2<M && arr[i-1][j+1]=='E' && arr[i-2][j+2]=='E'){
                        cnt += 1;
                    }
                    // (3). 3시 방향 확인
                    if(j+2<M && arr[i][j+1]=='E' && arr[i][j+2]=='E'){
                        cnt += 1;
                    }
                    // (4). 5시 방향 확인
                    if(i+2<N && j+2<M && arr[i+1][j+1]=='E' && arr[i+2][j+2]=='E'){
                        cnt += 1;
                    }
                    // (5). 6시 방향 확인
                    if(i+2<N && arr[i+1][j]=='E' && arr[i+2][j]=='E'){
                        cnt += 1;
                    }
                    // (6). 7시 방향 확인
                    if(i+2<N && j-2>=0 && arr[i+1][j-1]=='E' && arr[i+2][j-2]=='E'){
                        cnt += 1;
                    }
                    // (7). 9시 방향 확인
                    if(j-2>=0 && arr[i][j-1]=='E' && arr[i][j-2]=='E'){
                        cnt += 1;
                    }
                    // (8). 10시 방향 확인
                    if(i-2>=0 && j-2>=0 && arr[i-1][j-1]=='E' && arr[i-2][j-2]=='E'){
                        cnt += 1;
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}