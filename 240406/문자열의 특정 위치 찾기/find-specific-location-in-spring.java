import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] arr = s.toCharArray();
        String alpha = sc.next();

        int index = -1;
        for(int i=0; i<arr.length; i++){
            if(Character.toString(arr[i]).equals(alpha)){
                index = i;
                break;
            }
        }

        if(index == -1){
            System.out.println("No");
        }
        else{
            System.out.println(index);
        }
    }
}