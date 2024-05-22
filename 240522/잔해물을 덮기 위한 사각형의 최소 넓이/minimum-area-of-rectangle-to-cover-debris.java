import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] map = new int[2001][2001];

        int x1 = sc.nextInt() + 1000;
        int y1 = sc.nextInt() + 1000;
        int x2 = sc.nextInt() + 1000;
        int y2 = sc.nextInt() + 1000;

        int x3 = sc.nextInt() + 1000;
        int y3 = sc.nextInt() + 1000;
        int x4 = sc.nextInt() + 1000;
        int y4 = sc.nextInt() + 1000;

        for(int x=x1; x<=x2; x++){
            for(int y=y1; y<=y2; y++){
                map[x][y] += 1;
            }
        }

        for(int x=x3; x<x4; x++){
            for(int y=y3; y<y4; y++){
                map[x][y] += 2;
            }
        }

        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[i].length; j++){
                if(map[i][j] == 1){
                    minX = Math.min(minX, i);
                    minY = Math.min(minY, j);
                    maxX = Math.max(maxX, i);
                    maxY = Math.max(maxY, j);
                }
            }
        }

        System.out.println((maxX-minX) * (maxY-minY));
    }
}