package CodeTest.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 노드사이의거리 {

    static int n;
    static boolean[][] isConnected;
    static int[][] distance;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        isConnected = new boolean[n + 1][n + 1];
        distance = new int[n + 1][n + 1];

        for(int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            isConnected[from][to] = true;
            isConnected[to][from] = true;
            distance[from][to] = dist;
            distance[to][from] = dist;
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            bfs(from, to);
        }

    }

    public static void bfs(int from, int to) {

        Queue<Integer> queue = new LinkedList<>();
        visited = new boolean[n + 1];

        queue.add(from);
        visited[from] = true;
        int[] ans = new int[n+1];

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            for(int i = 1; i <= n; i++) {
                if(isConnected[cur][i] && !visited[i]) {
                    ans[i] += distance[cur][i] + ans[cur];

                    if(i == to) {
                        System.out.println(ans[to]);
                        return;
                    }

                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
