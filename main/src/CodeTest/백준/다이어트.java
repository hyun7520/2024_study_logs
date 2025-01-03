package CodeTest.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 다이어트 {

    static int G;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        G = Integer.parseInt(br.readLine());

        solution();
    }

    public static void solution() {

        List<Integer> list = new ArrayList<>();
        int cur = 1, past = 1;
        int cal;

        // cur * cur - past * past = G
        while(true) {
            cal = cur * cur - past * past;
            if(cal > G && cur - past == 1) {
                break;
            }
            if (cal > G) {
                past++;
            }
            else {
                cur++;
            }

            if(cal == G) list.add(cur - 1);
        }

        if(list.isEmpty()) {
            System.out.println(-1);
        } else {
            for(int w : list) {
                System.out.println(w);
            }
        }
    }
}
