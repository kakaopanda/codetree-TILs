import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[6];

        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<arr.length/2; i++){
            int sum = arr[i] + arr[arr.length-i-1];
            list.add(sum);
        }

        Collections.sort(list);
        int min = list.get(2) - list.get(0);

        System.out.println(min);
    }
}