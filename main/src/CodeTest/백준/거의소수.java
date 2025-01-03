package CodeTest.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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

        boolean[] isPrime = new boolean[(int) Math.sqrt(B) + 1];

        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for(int i = 2; i < isPrime.length; i++) {
            if(!isPrime[i]) {
                continue;
            }
            for(int j = i * 2; j < isPrime.length; j += i) {
                isPrime[j] = false;
            }
        }

        int answer = 0;
        for(int i = 2; i < isPrime.length; i++) {
            if(isPrime[i]) {
                for(long cur = i; cur <= B / i; cur *= i) {
                    if(cur * i >= A) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
}
