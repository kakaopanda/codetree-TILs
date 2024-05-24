import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] arr = s.toCharArray();
        int answer = 0;

        ArrayList<Integer> openIndex = new ArrayList<>();
        ArrayList<Integer> closeIndex = new ArrayList<>();

        for(int i=0; i<arr.length-1; i++){
            if(arr[i] == '('){
                if(arr[i+1] == '('){
                    openIndex.add(i);
                }
            }

            else if(arr[i] == ')'){
                if(arr[i+1] == ')'){
                    closeIndex.add(i);
                }
            }
        }

        for(int i=0; i<openIndex.size(); i++){
            for(int j=0; j<closeIndex.size(); j++){
                if(openIndex.get(i) < closeIndex.get(j)){
                    answer += 1;                    
                }
            }
        }

        System.out.println(answer);
    }
}