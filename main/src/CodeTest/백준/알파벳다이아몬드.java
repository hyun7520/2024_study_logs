package CodeTest.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 알파벳다이아몬드 {

    static int N, R1, R2, C1, C2;
    static char[] alphabet;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        alphabet = new char[26];

        for(int i = 'a'; i <= 'z'; i++) {
            alphabet[i - 'a'] = (char) i;
        }

        N = Integer.parseInt(st.nextToken());
        R1 = Integer.parseInt(st.nextToken());
        C1 = Integer.parseInt(st.nextToken());
        R2 = Integer.parseInt(st.nextToken());
        C2 = Integer.parseInt(st.nextToken());

        solution();
    }

    public static void solution() {

        int length = 2 * N - 1;
        StringBuilder sb = new StringBuilder();

        for(int i = R1; i < R2 + 1; i++) {
            for(int j = C1; j < C2 + 1; j++) {
                int nx = i % length;
                int ny = j % length;
                int dist = Math.abs(N - 1 - nx) + Math.abs(N - 1 - ny);
                if(dist > N - 1) {
                    sb.append('.');
                } else {
                    sb.append(alphabet[dist % 26]);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
