import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[][] map = new int[N+1][N+1];

        // 동(0), 남(1), 서(2), 북(3)
        int[][] delta = {{0,1},{1,0},{0,-1},{-1,0}};

        int t = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        int d = direction(sc.next());

        for(int i=0; i<t; i++){
            int dr = r + delta[d][0];
            int dc = c + delta[d][1];

            if(isRange(dr, dc)){
                r = dr;
                c = dc;
            }
            else{
                d = (d + 2) % 4;
            }
        }

        System.out.println(r + " " + c);
    }

    public static int direction(String s){
        if(s.equals("U")){
            return 3;
        }
        else if(s.equals("D")){
            return 1;
        }
        else if(s.equals("R")){
            return 0;
        }
        else if(s.equals("L")){
            return 2;
        }

        return -1;
    }

    public static boolean isRange(int x, int y){
        return (x>=1 && x<N && y>=1 && y<N);
    }
}