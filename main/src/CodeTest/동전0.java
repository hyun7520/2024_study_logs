package CodeTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class 동전0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int answer = 0;

        List<Integer> arr = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }

        for(int i = arr.size() - 1; i >= 0; i--) {
            if(k < arr.get(i)) {
                continue;
            } else {
                answer += k / arr.get(i);
                k %= arr.get(i);
            }
        }

        System.out.println(answer);
    }
}
