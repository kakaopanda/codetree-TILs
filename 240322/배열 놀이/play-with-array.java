import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        
        int index = 0;
        for(int i=0; i<q; i++){
            switch(sc.nextInt()){
                case 1:
                    index = sc.nextInt();
                    System.out.println(arr[index-1]);
                    break;
                case 2:
                    int num = sc.nextInt();
                    index = 0;
                    for(int j=0; j<arr.length; j++){
                        if(num == arr[j]){
                            index = j;
                            break;
                        }
                    }
                    System.out.println(index+1);
                    break;
                case 3:
                    int start = sc.nextInt();
                    int end = sc.nextInt();
                    for(int j=start-1; j<end; j++){
                        System.out.print(arr[j] + " ");
                    }
                    break;
            }
        }
    }
}