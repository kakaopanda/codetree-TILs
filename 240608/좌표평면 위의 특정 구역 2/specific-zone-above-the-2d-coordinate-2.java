import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];

        for(int i=0; i<n; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        int minArea = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            int minX = Integer.MAX_VALUE;
            int minY = Integer.MAX_VALUE;
            int maxX = Integer.MIN_VALUE;
            int maxY = Integer.MIN_VALUE;

            for(int j=0; j<n; j++){
                if(i==j){
                    continue;
                }

                minX = Math.min(minX, arr[j][0]);
                minY = Math.min(minY, arr[j][1]);
                maxX = Math.max(maxX, arr[j][0]);
                maxY = Math.max(maxY, arr[j][1]);
            }

            minArea = Math.min(minArea, (maxX-minX)*(maxY-minY));
        }

        System.out.println(minArea);
    }
}