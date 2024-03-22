import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String[] arr = {"L","E","B","R","O","S"};

        int index = -1;
        for(int i=0; i<arr.length; i++){
            if(str.equals(arr[i])){
                index = i;
                break;
            }
        }
        if(index != -1){
            System.out.println(index);
        }
        else{
            System.out.println("None");
        }
    }
}