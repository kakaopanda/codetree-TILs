import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] map = new int[201][201];

        for(int i=0; i<n; i++){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            for(int x=x1; x<x2; x++){
                for(int y=y1; y<y2; y++){
                    map[x][y] = 1;
                }
            }

        }

        int area = 0; 
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[i].length; j++){
                if(map[i][j] == 1){
                    area += 1;
                }
            }
        }

        System.out.println(area);
    }
}