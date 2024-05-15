import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        int n = sc.nextInt();
        int k = sc.nextInt();
        String T = sc.next();

        for(int i=0; i<n; i++){
            String s = sc.next();
            if(s.length() >= T.length()){
                if(s.substring(0,T.length()).equals(T)){
                    list.add(s);
                }
            }
        }
        Collections.sort(list);

        System.out.println(list.get(k-1));
    }
}