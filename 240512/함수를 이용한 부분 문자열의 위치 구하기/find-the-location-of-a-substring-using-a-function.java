import java.util.*;

public class Main {
    static int index = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String target = sc.next();

        findString(input, target);
        System.out.println(index);
    }

    public static void findString(String input, String target){
        for(int i=0; i<=input.length()-target.length(); i++){
            boolean find = false;
            if(input.substring(i, i+1).equals(target.substring(0, 1))){
                find = true;
                for(int j=1; j<target.length(); j++){
                    if(input.substring(i+j, i+j+1).equals(target.substring(j, j+1))){
                        continue;
                    }
                    else{
                        find = false;
                        break;
                    }
                }
            }

            if(find){
                index = i;
                return;
            }
        }
    }
}