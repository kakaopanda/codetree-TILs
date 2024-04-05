import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        int x = n-1, y = n-1;
        int num = 1;
        boolean check = true;
        while(true){
            if(n%2 == 1){
                arr[x][y] = num++;
                if(x==0 && y==0){
                    break;
                }
                else{
                    // 열 방향이 올라가는 방향일때
                    if(check){
                        if(x == 0){
                            check = false;
                            y -= 1;
                            continue;
                        }
                        x -= 1;
                    }
                    // 열 방향이 내려가는 방향일때
                    else{
                        if(x == n-1){
                            check = true;
                            y -= 1;
                            continue;
                        }
                        x += 1;
                    }
                }
            }
            else if(n%2 == 0){
                arr[x][y] = num++;
                if(x==n-1 && y==0){
                    break;
                }
                else{
                    // 열 방향이 올라가는 방향일때
                    if(check){
                        if(x == 0){
                            check = false;
                            y -= 1;
                            continue;
                        }
                        x -= 1;
                    }
                    // 열 방향이 내려가는 방향일때
                    else{
                        if(x == n-1){
                            check = true;
                            y -= 1;
                            continue;
                        }
                        x += 1;
                    }
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}