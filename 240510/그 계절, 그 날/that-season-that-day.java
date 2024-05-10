import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Y = sc.nextInt();
        int M = sc.nextInt();
        int D = sc.nextInt();

        String answer = "-1";

        if(isLeapYear(Y)){
            if(isLeapDay(M, D)){
                answer = season(M);
            }
        }
        else{
            if(isDay(M, D)){
                answer = season(M);
            }
        }

        System.out.println(answer);
    }

    public static boolean isLeapYear(int n){
        if(n%4 == 0){
            if(n%100 == 0){
                if(n%400 == 0){
                    return true;
                }
                return false;
            }
            return true;
        }

        return false;
    }

    // 31 29 31 30 31 30
    // 31 31 30 31 30 31
    public static boolean isLeapDay(int M, int D){
        switch(M){
            case 1:
                if(D>=1 && D<=31){
                    return true;
                }
                break;
            case 2:
                if(D>=1 && D<=29){
                    return true;
                }
                break;
            case 3:
                if(D>=1 && D<=31){
                    return true;
                }            
                break;
            case 4:
                if(D>=1 && D<=30){
                    return true;
                }            
                break;
            case 5:
                if(D>=1 && D<=31){
                    return true;
                }            
                break;
            case 6:
                if(D>=1 && D<=30){
                    return true;
                }            
                break;
            case 7:
                if(D>=1 && D<=31){
                    return true;
                }            
                break;
            case 8:
                if(D>=1 && D<=31){
                    return true;
                }            
                break;
            case 9:
                if(D>=1 && D<=30){
                    return true;
                }            
                break;
            case 10:
                if(D>=1 && D<=31){
                    return true;
                }            
                break;
            case 11:
                if(D>=1 && D<=30){
                    return true;
                }            
                break;
            case 12:
                if(D>=1 && D<=31){
                    return true;
                }            
                break;
            default:
                return false;
        }

        return false;
    }

    // 31 28 31 30 31 30
    // 31 31 30 31 30 31   
    public static boolean isDay(int M, int D){
        switch(M){
            case 1:
                if(D>=1 && D<=31){
                    return true;
                }
                break;
            case 2:
                if(D>=1 && D<=28){
                    return true;
                }
                break;
            case 3:
                if(D>=1 && D<=31){
                    return true;
                }            
                break;
            case 4:
                if(D>=1 && D<=30){
                    return true;
                }            
                break;
            case 5:
                if(D>=1 && D<=31){
                    return true;
                }            
                break;
            case 6:
                if(D>=1 && D<=30){
                    return true;
                }            
                break;
            case 7:
                if(D>=1 && D<=31){
                    return true;
                }            
                break;
            case 8:
                if(D>=1 && D<=31){
                    return true;
                }            
                break;
            case 9:
                if(D>=1 && D<=30){
                    return true;
                }            
                break;
            case 10:
                if(D>=1 && D<=31){
                    return true;
                }            
                break;
            case 11:
                if(D>=1 && D<=30){
                    return true;
                }            
                break;
            case 12:
                if(D>=1 && D<=31){
                    return true;
                }            
                break;
            default:
                return false;
        }

        return false;
    }

    public static String season(int M){
        if(M>=3 && M<=5){
            return "Spring";
        }
        else if(M>=6 && M<=8){
            return "Summer";
        }
        else if(M>=9 && M<=11){
            return "Fall";
        }
        else if(M==1 || M==2 || M==12){
            return "Winter";
        }

        return "Error";
    }
}