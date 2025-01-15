package CodeTest.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 암호코드 {

    static String str;
    static char[] password;
    static int[] dp;
    static final int div = 1000000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        password = str.toCharArray();
        dp = new int[str.length() + 1];

        dp[0] = 1;
        for(int i = 1; i < str.length() + 1; i++) {
            // 현재 자릿수를 탐색
            int curDigit = str.charAt(i - 1) - '0';
            // 0일 경우 대응하는 알파벳이 없으므로 패스한다. 1 -> A / 26 -> Z
            if(curDigit >= 1 && curDigit <= 9) {
                // 이 경우 단어 하나만으로 단어가 될 수 있으므로 이전 가짓수에 1을 더하고 저장해준다.
                // -> 혼자 쓰일 수 있는 경우
                dp[i] += dp[i - 1];
                dp[i] = dp[i] % div;
            }

            // 첫 글자일 경우 continue
            // -> dp[i] = dp[i - 1] + dp[i - 2]
            if(i == 1) continue;

            // 여기서부터 2가지 숫자로 조합이 가능한지 확인
            // 바로 이전 숫자가 0일 경우 01, 02 와 같은 형태는 대은되는 알파벳이 없기 때문에 패스
            int prevDigit = str.charAt(i-2) - '0';
            if(prevDigit == 0) {
                continue;
            }

            // 0이 아닐경우 이전 숫자를 10의 자리로 현재 숫자로 1의 자리로 한다.
            int fullDigit = prevDigit * 10 + curDigit;
            // 이때 숫자가 주어진 범위 안에 있을 경우 dp[i-2]를 현재 dp 인덱스에 더해준다.
            // dp[i-1]은 위쪽에서 이미 함
            if(fullDigit >= 1 && fullDigit <= 26) {
                dp[i] += dp[i - 2];
                dp[i] = dp[i] % div;
            }
        }

        System.out.println(dp[str.length()]);
    }
}
