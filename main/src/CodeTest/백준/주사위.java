package CodeTest.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 주사위 {

    static long[] dice;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        dice = new long[6];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < 6; i++) {
            dice[i] = Long.parseLong(st.nextToken());
        }

        System.out.println(solution(n));
    }

    public static long solution(int n) {
        long answer = 0;
        long face1 = dice[0];
        long face2 = Integer.MAX_VALUE;
        long face3 = 0;

        if(n == 1) {
            Arrays.sort(dice);
            answer += Arrays.stream(dice).sum() - dice[5];
            return answer;
        }

//        a = 0, b = 1, c = 2, d = 3, e = 4, f = 5
//            +---+
//            | D |
//        +---+---+---+---+
//        | E | A | B | F |
//        +---+---+---+---+
//            | C |
//            +---+

        for(int i = 1; i < 6; i++) {
            face1 = Math.min(dice[i], face1);
        }

        for(int i = 0; i < 6; i++) {
            for(int j = i+1; j < 6; j++) {
                if(i + j != 5 && i != j) {
                    face2 = Math.min(dice[i] + dice[j], face2);
                }
            }
        }

        for(int i = 0; i < 3; i++) {
            face3 += Math.min(dice[i], dice[5-i]);
        }

        answer += face1 * (4L * (n-2) * (n-1) + (long) (n - 2) * (n-2))
                + face2 * (4L * (n-1) + 4L * (n-2))
                + face3 * 4;

        return answer;
    }
}
