import java.util.*;

public class Main {
    static int N, T;
    static String S;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        T = sc.nextInt();
        S = sc.next();
        int[][] map = new int[N][N];

        // 북(0), 동(1), 남(2), 서(3)
        int[][] delta = {{-1,0},{0,1},{1,0},{0,-1}};
        int dir = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                map[i][j] = sc.nextInt();
            }
        }

        int r = N/2;
        int c = N/2;
        int sum = map[r][c];

        for(int i=0; i<S.length(); i++){
            String command = S.substring(i,i+1);
            if(command.equals("L")){
                dir = ((dir - 1) + 4) % 4; 
            }
            else if(command.equals("R")){
                dir = (dir + 1) % 4;
            }
            else if(command.equals("F")){
                int dr = r + delta[dir][0];
                int dc = c + delta[dir][1];

                if(isRange(dr,dc)){
                    r = dr;
                    c = dc;
                    sum += map[r][c];
                }
            }
        }

        System.out.println(sum);
    }

    public static boolean isRange(int r, int c){
        return (r>=0 && r<N && c>=0 && c<N);
    }
}