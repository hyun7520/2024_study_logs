package CodeTest.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 3079
public class 입국심사 {

    static int N;
    static int M;
    static int[] arr;
    static long answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        solution();

        System.out.println(answer);
    }

    public static void solution() {

        long left = 0;
        long right = arr[arr.length - 1] * (long) M;

        while(left <= right) {
            long done = 0;
            long mid = (left + right) / 2;

            for(long time : arr) {
                done += mid / time;
                // done이 M보다 커질 수 있으며 이 경우 오버플로우가 발생할 수 있다.
                if(done > M) break;
            }

            if(done < M) {
                left = mid + 1;
            } else {
                answer = mid;
                right = mid - 1;
            }
        }
    }
}
