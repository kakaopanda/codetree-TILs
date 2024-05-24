import java.util.*;

public class Main {
    static int N, M;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int[][] map = new int[N][M];

        // 동(0), 남(1), 서(2), 북(3)
        int[][] delta = {{0,1},{1,0},{0,-1},{-1,0}};
        int dir = 0;

        int r = 0;
        int c = 0;
        int num = 1;

        for(int i=0; i<N*M; i++){
            // System.out.println(r + "," + c);
            if(num > (int)'Z'-'A'){
                num = 1;
            }

            if(map[r][c] == 0){
                map[r][c] = num++;

                int dr = r + delta[dir][0];
                int dc = c + delta[dir][1];

                if(!isRange(dr, dc)){
                    dir = (dir + 1) % 4;
                    dr = r + delta[dir][0];
                    dc = c + delta[dir][1];
                }
                else{
                    if(map[dr][dc] != 0){
                        dir = (dir + 1) % 4;
                        dr = r + delta[dir][0];
                        dc = c + delta[dir][1];
                    }
                }
                r = dr;
                c = dc;
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                System.out.print((char)('A' + map[i][j] - 1) + " ");
            }
            System.out.println();
        }

    }

    public static boolean isRange(int r, int c){
        return (r>=0 && r<N && c>=0 && c<M);
    }
}