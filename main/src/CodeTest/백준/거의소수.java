package CodeTest.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 거의소수 {
    // 1465

    private static long A, B;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        System.out.println(solution());
    }

    public static int solution() {

        boolean[] notPrime = new boolean[(int) Math.sqrt(B) + 1];

        notPrime[0] = notPrime[1] = true;
        for(int i = 2; i < notPrime.length; i++) {
            if(notPrime[i]) {
                continue;
            }
            for(int j = i * 2; j < notPrime.length; j += i) {
                notPrime[j] = true;
            }
        }

        int answer = 0;
        for(int i = 2; i < notPrime.length; i++) {
            if(!notPrime[i]) {
                long cur = i;
                while(cur <= (double) B / i && cur >= (double) A / i) {
                    answer++;
                    cur *= i;
                }
            }
        }
        return answer;
    }
}
