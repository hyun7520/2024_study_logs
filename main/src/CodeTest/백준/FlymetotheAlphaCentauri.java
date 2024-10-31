package CodeTest.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FlymetotheAlphaCentauri {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            System.out.println(solution(x, y));
        }

    }

    public static int solution(int x, int y) {

        int dist = y - x;
        int max = (int) Math.sqrt(dist);

        if(max == Math.sqrt(dist)) {
            return 2 * max - 1;
        }
        if(dist <= max * max + max) {
            return 2 * max;
        } else {
            return 2 * max + 1;
        }
    }
}
