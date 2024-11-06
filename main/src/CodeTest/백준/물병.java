package CodeTest.백준;

import java.util.Scanner;

public class 물병 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        System.out.println(solution(n, k));

    }

    public static int solution(int n, int k) {
        int answer = 0;

        if(n < k) return 0;

        while(true) {
            String bit = Integer.toBinaryString(n);
            int bitCnt = 0;
            for(int i = 0; i < bit.length(); i++) {
                if(bit.charAt(i) == '1') bitCnt++;
            }
            if(bitCnt > k) {
                answer++;
                n++;
            }
            if(bitCnt <= k) {
                break;
            }
        }

        return answer;
    }
}
