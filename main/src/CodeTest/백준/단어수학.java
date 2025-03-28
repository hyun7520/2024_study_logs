package CodeTest.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 1339
public class 단어수학 {

    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[26];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            int idx = 0;
            for(int j = str.length() - 1; j >= 0; j--) {
                arr[str.charAt(j) - 'A'] += (int) Math.pow(10, idx);
                idx++;
            }
        }

        Arrays.sort(arr);

        int max = 9;
        int answer = 0;
        for(int i = arr.length - 1; i >= 0; i--) {
            if(i == 0) {
                break;
            }
            answer += max * arr[i];
            max--;
        }

        System.out.println(answer);
    }
}
