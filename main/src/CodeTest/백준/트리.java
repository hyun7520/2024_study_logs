package CodeTest.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 트리 {

    static HashMap<Integer, List<Integer>> tree;
    static int answer = 0;
    static Set<Integer> deleted;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        tree = new HashMap<>();
        deleted = new HashSet<>();

        for(int i = 0; i < n; i++) {
            tree.put(i, new ArrayList<>());
        }

        for(int i = 0; i < n; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if(parent == -1) continue;
            tree.get(parent).add(i);
        }

        int d = Integer.parseInt(br.readLine());

        deleted.add(d);
        solution(d);
        System.out.println(answer);
    }

    public static void solution(int d) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(d);

        while(!queue.isEmpty()) {
            int q = queue.poll();
            List<Integer> curNode = tree.get(q);
            for (Integer i : curNode) {
                if (!deleted.contains(i)) {
                    queue.add(i);
                }
                deleted.add(i);
            }

        }

        for(int i = 0; i < tree.size(); i++) {
            if(!deleted.contains(i) && tree.get(i).isEmpty()) {
                answer++;
            }
        }
    }
}
