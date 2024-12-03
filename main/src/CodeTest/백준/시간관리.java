package CodeTest.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 시간관리 {

    static int[][] works;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        works = new int[n][2];
        StringTokenizer st;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            // 걸리는 시간
            works[i][0] = Integer.parseInt(st.nextToken());
            // 끝내야하는 시간
            works[i][1] = Integer.parseInt(st.nextToken());
        }

        // 내림차순
        Arrays.sort(works, (o1, o2) -> o2[1] - o1[1]);

        System.out.println(solution());
    }

    public static int solution() {
        int answer = -1;

        int temp = works[0][1] - works[0][0];

        for(int i = 1; i < works.length; i++) {
            if(works[i][1] < temp) {
                temp = works[i][1];
            }
            temp -= works[i][0];
        }

        if(temp > 0) {
            answer = temp;
        }

        return answer;
    }
}
