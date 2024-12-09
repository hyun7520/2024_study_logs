package CodeTest.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 무한수열 {

    static Map<Long, Long> map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        map = new HashMap<>();

        long n = Long.parseLong(st.nextToken());
        long p = Long.parseLong(st.nextToken());
        long q = Long.parseLong(st.nextToken());

        map.put(0L, 1L);
        System.out.println(solution(n, p, q));
    }

    public static long solution(long n, long p, long q) {

        if(map.containsKey(n)) {
            return map.get(n);
        }

        long first = solution((long)Math.floor(n/p), p, q);
        long second = solution((long)Math.floor(n/q), p, q);
        map.put(n, first + second);
        return first + second;
    }
}
