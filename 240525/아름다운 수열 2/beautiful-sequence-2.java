import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] A = new int[n];
        int[] B = new int[m];

        for(int i=0; i<n; i++){
            A[i] = sc.nextInt();
        }

        for(int i=0; i<m; i++){
            B[i] = sc.nextInt();
        }
        Arrays.sort(B);

        int cnt = 0;
        for(int i=0; i<=n-m; i++){
            ArrayList<Integer> list = new ArrayList<>();
            for(int j=i; j<i+m; j++){
                list.add(A[j]);
            }
            Collections.sort(list);

            boolean check = true;
            for(int k=0; k<list.size(); k++){
                if(list.get(k) != B[k]){
                    check = false;
                    break;
                }
            }

            if(check){
                cnt += 1;
            }
        }

        System.out.println(cnt);
    }
}