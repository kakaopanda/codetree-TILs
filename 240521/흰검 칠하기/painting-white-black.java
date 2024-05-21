import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Color[] arr = new Color[200001];
        for(int i=0; i<arr.length; i++){
            arr[i] = new Color();
        }

        int pos = 100000;
        for(int i=0; i<n; i++){
            int move = sc.nextInt();
            String direction = sc.next();

            if(direction.equals("R")){
                while(true){
                    if(move <= 0){
                        break;
                    }
                    else{
                        arr[pos].blackCnt++;
                        arr[pos].recentColor = "B";
                        if(move > 1){
                            pos++;
                        }
                        move--;
                    }
                }
            }
            else if(direction.equals("L")){
                while(true){
                    if(move <= 0){
                        break;
                    }
                    else{
                        arr[pos].whiteCnt++;
                        arr[pos].recentColor = "W";
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
        int grayCnt = 0;

        for(int i=0; i<arr.length; i++){
            if(arr[i].whiteCnt>=2 && arr[i].blackCnt>=2){
                grayCnt += 1;
            }
            else if(arr[i].recentColor.equals("W")){
                whiteCnt += 1;
            }
            else if(arr[i].recentColor.equals("B")){
                blackCnt += 1;
            }
        }

        System.out.println(whiteCnt + " " + blackCnt + " " + grayCnt);
    }
}

class Color{
    int whiteCnt;
    int blackCnt;
    String recentColor;

    public Color(){
        whiteCnt = 0;
        blackCnt = 0;
        recentColor = "";
    }
}