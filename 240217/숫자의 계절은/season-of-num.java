import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        String s = "";

        switch(m){
            case 1:
            case 2:
            case 12:
                s = "Winter";
                break;
            case 3:
            case 4:
            case 5:
                s = "Spring";
                break;
            case 6:
            case 7:
            case 8:
                s = "Summer";
                break;
            case 9:
            case 10:
            case 11:
                s = "Fall";
                break;
        }   
        System.out.println(s);
    }
}