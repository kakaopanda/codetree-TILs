import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[][] map = new int[N][N];

        // 동(0), 북(1), 서(2), 남(3)
        int[][] delta = {{0,1},{-1,0},{0,-1},{1,0}};
        int dir = 0;

        int r = N/2;
        int c = N/2;

        for(int i=1; i<=N*N; i++){
            if(map[r][c] == 0){
                map[r][c] = i;

                int dr = r + delta[dir][0];
                int dc = c + delta[dir][1];

                if(!isRange(dr, dc)){
                    dir = (dir + 1) % 4;
                    dr = r + delta[dir][0];
                    dc = c + delta[dir][1];
                }
                else{
                    if(map[r][c] != 0){
                        dr = r + delta[dir][0];
                        dc = c + delta[dir][1];
                    }
                }
                r = dr;
                c = dc;
            }
        }

        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[i].length; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isRange(int r, int c){
        return (r>=0 && r<N && c>=0 && c<N);
    }
}