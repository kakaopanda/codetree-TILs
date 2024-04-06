import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();

        int cnt = 0;
        while(true){
            String s = sc.next();
            if(s.equals("0")){
                break;
            }
            cnt += 1;

            if(cnt%2 == 1){
                list.add(s);
            }
        }

        System.out.println(cnt);
        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}