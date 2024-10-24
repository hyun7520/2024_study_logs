package CodeTest.백준;

import java.util.Scanner;

public class 더하기사이클 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(solution(n));
    }

    public static int solution(int n) {
        int answer = 0;
        int now = n;

        do {
            int ten = (now % 10) * 10;
            int one = ( (now / 10) + now % 10 ) % 10;
            now = ten + one;
            answer++;
        } while(now != n);


        return answer;
    }
}
