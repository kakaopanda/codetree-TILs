import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] map = new int[2000][2000];

        int x1 = sc.nextInt() + 1000;
        int y1 = sc.nextInt() + 1000;
        int x2 = sc.nextInt() + 1000;
        int y2 = sc.nextInt() + 1000;

        int x3 = sc.nextInt() + 1000;
        int y3 = sc.nextInt() + 1000;
        int x4 = sc.nextInt() + 1000;
        int y4 = sc.nextInt() + 1000;

        for(int x=x1; x<x2; x++){
            for(int y=y1; y<y2; y++){
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

        // 첫 번째 직사각형이 두 번째 직사각형 내부에 완전히 포함되어 좌표가 갱신되지 않는 경우
        if(maxX==Integer.MIN_VALUE || maxY==Integer.MIN_VALUE ||
        minX==Integer.MAX_VALUE || minY==Integer.MAX_VALUE){
            System.out.println(0);
        }
        else{
            System.out.println((maxX-minX+1) * (maxY-minY+1));
        }
    }
}