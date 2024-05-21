import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 원점에서 시작하여, 영역은 왼쪽, 오른쪽으로 최대 1,000번 움직일 수 있으므로
        // 영역의 크기는 [-1000, 1000]을 충족해야한다.
        int[] arr = new int[2001];
        int position = 1000; 

        for(int i=0; i<n; i++){
            int move = sc.nextInt();
            String direction = sc.next();

            if(direction.equals("R")){
                while(true){
                    if(move <= 0){
                        break;
                    }
                    else{
                        arr[position++]++;
                        move--;
                    }
                }
            }
            else if(direction.equals("L")){
                while(true){
                    if(move < 0){
                        break;
                    }
                    else{
                        arr[position--]++;
                        move--;
                    }
                }
            }
        }

        int cnt = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] >= 2){
                cnt += 1;
            }
        }
        System.out.println(cnt);
    }
}