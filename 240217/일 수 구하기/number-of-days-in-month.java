import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Calendar cal = Calendar.getInstance();
        cal.set(2024, n-1, 1);
        System.out.println(cal.getActualMaximum(Calendar.DATE));        
    }
}