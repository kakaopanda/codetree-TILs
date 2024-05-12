import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        print(n, 1, n);
    }

    public static void print(int start, int end, int standard){
        if(start == 0){
            if(end == standard+1){
                return;
            }
            else{
                System.out.print(end + " ");
                print(start, end+1, standard);
            }
        }
        else{
            System.out.print(start + " ");
            print(start-1, end, standard);
        }
    }
}