package CodeTest.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1916
public class 최소비용구하기_오답풀이_오버플로우 {

    static int N, M;
    static int[][] node;
    static int A, B;
    static int answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        node = new int[N + 1][N + 1];
        StringTokenizer st;

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int fee = Integer.parseInt(st.nextToken());
            node[from][to] = fee;
        }

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        solution();

        System.out.println(answer);
    }

    public static void solution() {

        answer = Integer.MAX_VALUE;

        for(int i = 0; i < N + 1; i++) {
            if(node[A][i] != 0) {
                dfs(A, i, node[A][i]);
            }
        }
    }

    public static void dfs(int start, int end, int fee) {

        if(end == B || node[start][end] == 0) {
            answer = Math.min(answer, fee);
            return;
        }

        for(int i = 1; i < N + 1; i++) {
            if(node[end][i] != 0) {
                dfs(end, i, fee + node[end][i]);
            }
        }
    }
}
