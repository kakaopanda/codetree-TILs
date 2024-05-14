import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        char[] a1 = s1.toCharArray();
        Arrays.sort(a1);

        String s2 = sc.next();
        char[] a2 = s2.toCharArray();
        Arrays.sort(a2);

        boolean equal = true;
        for(int i=0; i<a1.length; i++){
            if(a1[i] != a2[i]){
                equal = false;
                break;
            }
        }

        if(equal){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }
}