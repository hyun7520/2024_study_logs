import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS와BFS {

    static Queue<Integer> queue = new LinkedList<>();
    static int[][] arr;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();
    static int node, edge, start;

    public static void main(String[] args) throws IOException {
        // System.out.println("Hello World");

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        node = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        arr = new int[node+1][node+1];
        visit = new boolean[node+1];

        for(int i = 0; i < edge; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = arr[b][a] = 1;
        }
        dfs(start);
        sb.append("\n");
        visit = new boolean[node+1];
        bfs(start);

        System.out.println(sb);
    }

    public static void dfs(int start) {

        visit[start] = true;
        sb.append(start).append(" ");

        for(int i = 1; i <= node; i++) {
            if(arr[start][i] == 1 && !visit[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int start) {
        queue.add(start);
        visit[start] = true;

        while(!queue.isEmpty()) {
            start = queue.poll();
            sb.append(start).append(" ");

            for(int i = 1; i <= node; i++) {
                if(arr[start][i] == 1 && !visit[i]) {
                    queue.add(i);
                    visit[i] = true;
                }
            }
        }
    }
}
