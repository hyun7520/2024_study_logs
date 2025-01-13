package CodeTest.백준;

import java.io.*;
import java.util.*;

// 2660
public class 회장뽑기 {

    static int N;
    static int[][] friends;
    static int[] candidates;
    static List<Integer> answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        friends = new int[N + 1][N + 1];
        candidates = new int[N + 1];
        answer = new ArrayList<>();

        for(int i = 0; i <= N; i++){
            for(int j = 0; j <= N; j++){
                // 자기 자신을 확인하는 부분은 꼭 0으로 비워두기
                if(i != j) {
                    // 플로이드 워셜 알고리즘을 사용할 시 Integer.MAX_VALUE로 초기화하면 오버플로우가 발생할 수 있다.
                    // 추가 조건 체크를 사용하거나 매우 큰 값을 직접 입력하여 사용하자.
                    friends[i][j] = 99999999;
                }
            }
        }

        StringTokenizer st;
        while(true) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            if(from == -1 && to == -1) {
                break;
            }

            friends[from][to] = friends[to][from] = 1;
        }

        for(int k = 1; k <= N; k++) {
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    if(friends[i][j] > friends[i][k] + friends[k][j]) {
                        friends[i][j] = friends[i][k] + friends[k][j];
                    }
                }
            }
        }

        int score;
        int minScore = Integer.MAX_VALUE;
        for(int i = 1; i <= N; i++) {
            score = 0;
            for(int j = 1; j <= N; j++) {
                if(friends[i][j] != 99999999) {
                    score = Math.max(score, friends[i][j]);
                }
            }
            candidates[i] = score;
            minScore = Math.min(minScore, score);
        }

        int total = 0;
        for(int i = 1; i <= N; i++) {
            if(candidates[i] == minScore) {
                total++;
                answer.add(i);
            }
        }

        Collections.sort(answer);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(minScore + " " + total + "\n");
        for (Integer integer : answer) {
            bw.write(integer + " ");
        }

        bw.flush();
        bw.close();
    }
}
