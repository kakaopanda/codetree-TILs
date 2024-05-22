import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] map = new int[2000][2000];

        for(int i=1; i<=3; i++){
            int x1 = sc.nextInt() + 1000;
            int y1 = sc.nextInt() + 1000;
            int x2 = sc.nextInt() + 1000;
            int y2 = sc.nextInt() + 1000;

            for(int x=x1; x<x2; x++){
                for(int y=y1; y<y2; y++){
                    map[x][y] += i;
                }
            }
        }

        int area = 0;
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[i].length; j++){
                if(map[i][j]==1 || map[i][j]==2){
                    area += 1;
                }
            }
        }

        System.out.println(area);
    }
}