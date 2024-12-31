package CodeTest.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 강의실 {

    private static int n;
    private static int[][] lectures;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        lectures = new int[n][3];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++) {
                // 0: 강의 번호, 1: 강의 시작 시간, 2: 강의 종료시간
                lectures[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution());
    }

    public static int solution() {

        Arrays.sort(lectures, (o1, o2) -> {
            if(o1[1] - o2[1] == 0) return o1[2] - o2[2];
            else return o1[1] - o2[1];
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int[] lecture : lectures) {
            if (pq.isEmpty()) {
                pq.add(lecture[2]);
                continue;
            }
            int curTime = pq.peek();
            if (curTime > lecture[1]) {
                pq.add(lecture[2]);
            } else {
                pq.poll();
                pq.add(lecture[2]);
            }

        }

        return pq.size();
    }
}
