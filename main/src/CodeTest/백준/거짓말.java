package CodeTest.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 1043
public class 거짓말 {

    static int[] parent;
    static List<Integer> knowStory;
    static List<List<Integer>> parties;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        knowStory = new ArrayList<>();
        parties = new ArrayList<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < M;i ++) {
            parties.add(new ArrayList<>());
        }

        parent = new int[N + 1];

        for(int i = 1; i < N + 1; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int knowTotal = Integer.parseInt(st.nextToken());
        if(knowTotal == 0) {
            System.out.println(M);
            return;
        }
        for(int i = 0; i < knowTotal; i++) {
            knowStory.add(Integer.parseInt(st.nextToken()));
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int total = Integer.parseInt(st.nextToken());

            int x = Integer.parseInt(st.nextToken());
            parties.get(i).add(x);
            while(st.hasMoreTokens()) {
                int y = Integer.parseInt(st.nextToken());
                union(x, y);
                parties.get(i).add(y);
            }
        }

        int cnt = 0;
        for(int i = 0; i < M; i++) {
            boolean flag = true;
            for(int n : parties.get(i)) {
                if(knowStory.contains(find(parent[n]))) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    public static void union(int x, int y) {

        int nx = find(x);
        int ny = find(y);
        if(knowStory.contains(ny)) {
            int tmp = nx;
            nx = ny;
            ny = tmp;
        }
        parent[ny] = nx;
    }

    public static int find(int x) {
        if(parent[x] == x) return x;
        return find(parent[x]);
    }
}
