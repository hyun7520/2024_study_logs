package CodeTest.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class 머리톡톡 {

    static int n;
    static int[] heads;
    static HashMap<Integer, Integer> map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new HashMap<>();
        heads = new int[n + 1];

        for (int i = 0; i < n; i++) {
            heads[i] = Integer.parseInt(br.readLine());
            map.put(heads[i], map.getOrDefault(heads[i], 0) + 1);
        }

        solution();
    }

    public static void solution() {

        int[] answer = new int[n];

        for(int i = 0; i < n; i++) {
            int cur = heads[i];

            for(int j = 1; j <= Math.sqrt(cur); j++) {
                if(cur % j == 0) {
                    answer[i] += map.getOrDefault(j, 0);
                    if(j < Math.sqrt(cur)) {
                        answer[i] += map.getOrDefault(cur/j, 0);
                    }
                }
            }
        }

        for(int i = 0; i < n; i++) {
            System.out.println(answer[i] - 1);
        }
    }
}
