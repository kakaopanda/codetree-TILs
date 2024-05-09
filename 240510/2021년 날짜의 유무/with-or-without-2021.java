import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int D = sc.nextInt();

        if(isDay(M, D)){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }

    // 31 28 30 30 31 30
    // 31 31 30 31 30 31
    public static boolean isDay(int M, int D){
        switch(M){
            case 1:
                if(D>31){
                    return false;
                }
                break;
            case 2:
                if(D>28){
                    return false;
                }
                break;
            case 3:
                if(D>30){
                    return false;
                }
                break;
            case 4:
                if(D>30){
                    return false;
                }
                break;
            case 5:
                if(D>31){
                    return false;
                }
                break;
            case 6:
                if(D>30){
                    return false;
                }
                break;
            case 7:
                if(D>31){
                    return false;
                }
                break;
            case 8:
                if(D>31){
                    return false;
                }
                break;
            case 9:
                if(D>30){
                    return false;
                }
                break;
            case 10:
                if(D>31){
                    return false;
                }
                break;
            case 11:
                if(D>30){
                    return false;
                }
                break;
            case 12:
                if(D>31){
                    return false;
                }
                break;
            default:
                return false;
        }

        return true;
    }
}