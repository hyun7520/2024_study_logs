package CodeTest.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 2023
public class 신기한소수 {

    static int N;
    static List<Integer> answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        answer = new ArrayList<>();

        dfs(0, 0);

        Collections.sort(answer);

        for(int a : answer) {
            System.out.println(a);
        }
    }

    static void dfs(int cur, int depth) {
        if (depth == N) {
            answer.add(cur);
        }
        for(int i = 1; i < 10; i++) {
            int num = cur * 10 + i;
            if (checkPrime(num)) {
                dfs(num, depth + 1);
            }
        }
    }

    static boolean checkPrime(int k) {
        if(k < 2) return false;
        for(int i = 2; i * i <= k; i++) {
            if(k % i == 0) {
                return false;
            }
        }
        return true;
    }
}
