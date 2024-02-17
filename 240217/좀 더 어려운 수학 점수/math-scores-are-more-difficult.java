import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int aMath = sc.nextInt();
        int aEng = sc.nextInt();
        int bMath = sc.nextInt();
        int bEng = sc.nextInt();
        String s = "";

        if(aMath < bMath){
            s = "B";
        }
        else if(aMath > bMath){
            s = "A";
        }
        else{
            if(aEng < bEng){
                s = "B";
            }
            else{
                s = "A";
            }
        }
        System.out.println(s);
    }
}