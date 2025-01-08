package CodeTest.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 집합의표현 {

    static int n, m;
    static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];

        for(int i = 1; i < n + 1; i++) {
            parent[i] = i;
        }

        String cal;
        int a, b;

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            cal = st.nextToken();
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if(cal.equals("0")) {
                union(a, b);
            }
            else if(cal.equals("1")) {
                if(find(a) == find(b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }

        }
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b) {
            if(a < b) {
                parent[b] = a;
            }
            else {
                parent[a] = b;
            }
        }
    }

    public static int find(int p) {
        if(p == parent[p]) {
            return p;
        }

        return parent[p] = find(parent[p]);
    }
}
