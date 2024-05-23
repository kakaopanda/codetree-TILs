import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[][] map = new String[200][200];

        // 직사각형을 색칠할 색깔을 구분하는 인덱스
        // 홀수면 빨간색, 짝수면 파란색
        for(int i=1; i<=n; i++){
            int x1 = sc.nextInt() + 100;
            int y1 = sc.nextInt() + 100;
            int x2 = sc.nextInt() + 100;
            int y2 = sc.nextInt() + 100;

            String val = (i%2 == 1) ? "R" : "B";
            for(int x=x1; x<x2; x++){
                for(int y=y1; y<y2; y++){
                    map[x][y] = val;
                }
            }
        }

        int area = 0;
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[i].length; j++){
                try{
                    if(map[i][j].equals("B")){
                        area += 1;
                    }
                } catch(NullPointerException e){
                    continue;
                }
            }
        }

        System.out.println(area);
    }
}