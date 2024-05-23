import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[][] map = new int[N+1][N+1];
        int m = sc.nextInt();

        // 동(0), 서(1), 남(2), 북(3)
        int[][] delta = {{0,1},{0,-1},{1,0},{-1,0}};

        for(int i=0; i<m; i++){
            int r = sc.nextInt();
            int c = sc.nextInt();
            map[r][c] = 1;

            int cnt = 0;
            for(int d=0; d<4; d++){
                int dr = r + delta[d][0];
                int dc = c + delta[d][1];

                if(isRange(dr, dc)){
                    if(map[dr][dc] == 1){
                        cnt += 1;
                    }
                }
            }

            if(cnt == 3){
                System.out.println("1");
            }
            else{
                System.out.println("0");
            }
        }
    }

    public static boolean isRange(int r, int c){
        return (r>=1 && r<=N && c>=1 && c<=N);
    }
}