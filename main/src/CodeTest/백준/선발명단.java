package CodeTest.백준;

import java.io.*;
import java.util.StringTokenizer;

// 3980
public class 선발명단 {

    static int C;
    static int[][] position;
    static boolean[] visited;
    static int max;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        C = Integer.parseInt(br.readLine());

        for(int i = 0; i < C; i++) {
            position = new int[11][11];
            visited = new boolean[11];
            max = Integer.MIN_VALUE;
            for(int j = 0; j < 11; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int k = 0; k < 11; k++) {
                    position[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            dfsBacktrack(0, 0);
            bw.write(max + "\n");
        }

        bw.flush();
        bw.close();
    }

    public static void dfsBacktrack(int cur, int sum) {

        if(cur == 11) {
            max = Math.max(max, sum);
            return;
        }

        for(int i = 0; i < 11; i++) {
            if(!visited[i] && position[cur][i] != 0) {
                visited[i] = true;
                dfsBacktrack(cur + 1, sum + position[cur][i]);
                visited[i] = false;
            }
        }
    }
}
