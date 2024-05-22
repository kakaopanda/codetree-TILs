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

        // 첫 번째 직사각형의 잔해물을 덮기 위한 최소 직사각형을 구해야하므로
        // 배열에 대한 표현을 구간([x1,y1] ~ [x2-1,y2-1])으로 하되, 직사각형 길이에 1을 더해준다.
        // 지점으로 표현하면 실제 직사각형 좌표보다 1씩을 더해서 계산하는 꼴이 되버린다.
        
        // [2,1] ~ [7,4]
        // 지점 표현 : 2, 3, 4, 5, 6, 7 -> 가로 길이 6
        // 구간 표현 : 2, 3, 4, 5, 6 -> 가로 길이 5
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