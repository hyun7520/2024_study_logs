package CodeTest.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 동물원 {

    static long[][] cage;
    static int n;
    static int divide = 9901;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        cage = new long[n][3];
        // 현재 열의 케이지에 모두 사자를 넣지 않을 경우
        cage[0][0] = 1;
        // 왼쪽에만 사자를 넣을 경우
        cage[0][1] = 1;
        // 우측에
        cage[0][2] = 1;

        System.out.println(solution());

    }

    public static long solution() {

        for(int i = 1; i < n; i++) {
            cage[i][0] = (cage[i-1][0] + cage[i-1][1] + cage[i-1][2]) % divide;
            cage[i][1] = (cage[i-1][0] + cage[i-1][2]) % divide;
            cage[i][2] = (cage[i-1][0] + cage[i-1][1]) % divide;
        }

        return (cage[n-1][0] + cage[n-1][1] + cage[n-1][2]) % divide;
    }
}
