package CodeTest.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색칠1 {

    static int[][] paper;
    static int w, h, f, c;
    static int x1, x2, y1, y2;

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

    public static int solution() {
        int answer = 0;

        if(x1 > f) {

        }
        else if(x1 <= f) {

        }

        return answer;
    }
}
