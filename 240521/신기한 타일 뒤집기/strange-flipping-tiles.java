import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[200001];
        int pos = 100000;

        for(int i=0; i<n; i++){
            int move = sc.nextInt();
            String direction = sc.next();

            if(direction.equals("R")){
                while(true){
                    if(move < 0){
                        break;
                    }
                    else{
                        arr[pos] = 2;
                        if(move > 1){
                            pos++;
                        }
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
                        arr[pos] = 1;
                        if(move > 1){
                            pos--;
                        }
                        move--;
                    }
                }
            }
        }

        int whiteCnt = 0;
        int blackCnt = 0;

        for(int i=0; i<arr.length; i++){
            if(arr[i] == 1){
                whiteCnt += 1;
            }
            else if(arr[i] == 2){
                blackCnt += 1;
            }
        }

        System.out.println(whiteCnt + " " + blackCnt);
    }
}