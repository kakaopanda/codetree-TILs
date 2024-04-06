import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = new String[10];

        for(int i=0; i<arr.length; i++){
            arr[i] = sc.next();
        }
        String s = sc.next();
        
        boolean check = true;
        for(int i=0; i<arr.length; i++){
            if(Character.toString(arr[i].charAt(arr[i].length()-1)).equals(s)){
                System.out.println(arr[i]);
                check = false;
            }
        }
        
        if(check){
            System.out.println("None");
        }
    }
}