package CodeTest.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 무한수열2 {

    static Map<Long, Long> map;
    static int P, Q, X, Y;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        map = new HashMap<Long, Long>();

        long N = Long.parseLong(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        map.put(0L, 1L);
        System.out.println(solution(N));
    }

    public static long solution(long N) {

        if(N < 1) {
            return 1;
        }
        if(map.containsKey(N)) {
            return map.get(N);
        }

        long left = solution(N/P - X);
        long right = solution(N/Q - Y);
        long sum = left + right;
        map.put(N, sum);
        return sum;
    }
}
