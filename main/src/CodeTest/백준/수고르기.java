package CodeTest.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2230
public class 수고르기 {

    static int N, M;
    static int[] arr;
    static int min;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        solution();

        System.out.println(min);
    }

    public static void solution() {

        Arrays.sort(arr);

        int left = 0;
        int right = 1;
        min = Integer.MAX_VALUE;

        while(right < arr.length && left < arr.length) {
            if(arr[right] - arr[left] == M) {
                min = M;
                return;
            }
            if(right == left) {
                right++;
                continue;
            }
            if(arr[right] - arr[left] < M) {
                right++;
            }
            else if(arr[right] - arr[left] > M) {
                min = Math.min(min, Math.abs(arr[right] - arr[left]));
                left++;
            }
        }
    }
}
