import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[101];
        for(int i=0; i<arr.length; i++){
            arr[i] = "";
        }

        for(int i=0; i<n; i++){
            int index = sc.nextInt();
            arr[index] = sc.next();
        }

        int cntG, cntH, start, end;
        int max = Integer.MIN_VALUE;

        // 0 ~ N-1부터 i ~ N-1-j까지 반복
        // 사진에 찍히는 사람을 최대로 하는게 아닌, 사진의 크기를 최대로 해야한다.
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length; j++){
                cntG = 0;
                cntH = 0;
                start = -1;
                end = -1;

                for(int k=j; k<arr.length-i; k++){
                    if(arr[k].equals("G")){
                        cntG += 1;
                        if(start == -1){
                            start = k;
                        }
                        end = k;
                    }
                    else if(arr[k].equals("H")){
                        cntH += 1;
                        if(start == -1){
                            start = k;
                        }
                        end = k;
                    }
                }
                int distance = end - start;

                if(cntG!=0 && cntH!=0 && cntG == cntH){
                    max = Math.max(distance, max);
                }
                else if(cntG==0 && cntH!=0){
                    max = Math.max(distance, max);
                }
                else if(cntG!=0 && cntH==0){
                    max = Math.max(distance, max);
                }
            }
        }

        System.out.println(max);       
    }
}