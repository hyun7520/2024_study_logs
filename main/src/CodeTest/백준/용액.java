package CodeTest.백준;

import java.io.*;
import java.util.StringTokenizer;

// 2467
public class 용액 {

    static int N;
    static long[] liquid;
    static long[] answer;
    static long min, cur;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        liquid = new long[N];
        answer = new long[2];
        min = Long.MAX_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            liquid[i] = Long.parseLong(st.nextToken());
        }

        solution();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(answer[0] + " " + answer[1]);
        bw.flush();
        bw.close();
    }

    public static void solution() {

        int left = 0;
        int right = N - 1;

        while(left < right) {
            cur = liquid[left] + liquid[right];
            if(min > Math.abs(cur)) {
                min = Math.abs(cur);
                answer[0] = liquid[left];
                answer[1] = liquid[right];
            }
            if(cur > 0) {
                right--;
            } else if (cur < 0){
                left++;
            } else {
                break;
            }
        }
    }
}
