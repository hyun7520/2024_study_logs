package CodeTest.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1253
public class 좋다 {

    static int N, cnt;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        cnt = 0;
        for(int i = 0; i < N; i++) {
            solution(i);
        }

        System.out.println(cnt);
    }

    public static void solution(int cur) {

        int left = 0;
        int right = N - 1;
        while(true) {
            if(left == cur) {
                left++;
            }
            else if(right == cur) {
                right--;
            }

            if(left >= right) break;

            if(arr[left] + arr[right] > arr[cur]) {
                right--;
            }
            else if(arr[left] + arr[right] < arr[cur]){
                left++;
            }
            else {
                cnt++;
                break;
            }
        }
    }
}
