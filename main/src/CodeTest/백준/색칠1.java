package CodeTest.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색칠1 {

    static long w, h, f, c;
    static long x1, x2, y1, y2;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] input = new int[8];

        for(int i = 0; i < 8; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        w = input[0];
        h = input[1];
        f = input[2];
        c = input[3] + 1;
        x1 = input[4];
        y1 = input[5];
        x2 = input[6];
        y2 = input[7];

        System.out.println(solution());
    }

    public static long solution() {
        long answer = 0;

        long total = w * h;
        // 접힌 영역의 w 길이
        long folded;

        if(f > w / 2) {
            folded = w - f;
        } else {
            folded = f;
        }

        if(folded <= x1) {
            answer = total - c * (x2 - x1) * (y2 - y1);
        }
        else if(folded < x2) {
            answer = total - 2 * c * (folded - x1) * (y2 - y1) - c * (x2 - folded) * (y2 - y1);
        }
        else {
            answer = total - c * 2 * (x2 - x1) * (y2 - y1);
        }

        return answer;
    }
}
