import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=1; i<=n; i++){
            int num = sc.nextInt();
            list.add(num);

            if(i%2 == 1){
                Collections.sort(list);
                System.out.print(list.get(i/2) + " ");
            }
        }
    }
}