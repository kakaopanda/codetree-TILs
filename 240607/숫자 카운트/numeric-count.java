import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] B = new int[10][3];

        // 숫자 야구 -> 1번 카운트(스트라이크), 2번 카운트(볼)
        // B가 묻는 세자리 수에 대한 A의 답변을 기록한다.
        for(int i=0; i<n; i++){
            int num = sc.nextInt();
            int strike = sc.nextInt();
            int ball = sc.nextInt();

            B[i][0] = num;
            B[i][1] = strike;
            B[i][2] = ball;
        }

        // 123 ~ 987까지의 서로 다른 숫자 세 개로 구성된 세자리 수를 순회하면서
        // n개의 질문을 모두 충족하는 숫자를 카운트한다. (정답의 가능성이 있는 숫자)
        int cnt = 0;
        for(int i=1; i<=9; i++){
            for(int j=1; j<=9; j++){
                if(i!=j){
                    for(int k=1; k<=9; k++){
                        if(k!=i && k!=j){
                            int check = 0;

                            for(int l=0; l<n; l++){
                                String num = Integer.toString(B[l][0]);
                                int strike = 0;
                                int ball = 0;

                                int first = Integer.parseInt(num.substring(0,1));
                                int second = Integer.parseInt(num.substring(1,2));
                                int third = Integer.parseInt(num.substring(2,3));

                                if(i == first){
                                    strike += 1;
                                }
                                else if(i==second || i==third){
                                    ball += 1;
                                }

                                if(j == second){
                                    strike += 1;
                                }
                                else if(j==first || j==third){
                                    ball += 1;
                                }

                                if(k == third){
                                    strike += 1;
                                }
                                else if(k==first || k==second){
                                    ball += 1;
                                }

                                if(strike==B[l][1] && ball==B[l][2]){
                                    check += 1;
                                }
                            }

                            if(check == n){
                                cnt += 1;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}