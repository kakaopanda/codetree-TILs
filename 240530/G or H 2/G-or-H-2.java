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

        int cntG = 0;
        int cntH = 0;
        int startIndex = 0;
        int endIndex = 0;

        int max = Integer.MIN_VALUE;
        int startMax = 0;
        int endMax = 0;

        // 0 ~ N-1부터 i ~ N-1-j까지 반복
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length; j++){
                cntG = 0;
                cntH = 0;
                startIndex = 0;
                endIndex = 0;

                for(int k=j; k<arr.length-i; k++){
                    if(arr[k].equals("G")){
                        cntG += 1;
                        if(startIndex == 0){
                            startIndex = k;
                        }
                        endIndex = k;
                    }
                    else if(arr[k].equals("H")){
                        cntH += 1;
                        if(startIndex == 0){
                            startIndex = k;
                        }
                        endIndex = k;
                    }
                }

                if(cntG == cntH){
                    if(max < cntG + cntH){
                        max = cntG + cntH;
                        startMax = startIndex;
                        endMax = endIndex;
                    }
                }
                else if(cntG==0 && cntH!=0){
                    if(max < cntG){
                        max = cntG;
                        startMax = startIndex;
                        endMax = endIndex;
                    }
                }
                else if(cntG!=0 && cntH==0){
                    if(max < cntH){
                        max = cntH;
                        startMax = startIndex;
                        endMax = endIndex;
                    }
                }
            }
        }

        System.out.println(endMax - startMax);       
    }
}