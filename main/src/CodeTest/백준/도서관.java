package CodeTest.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 1461
public class 도서관 {

    static int N, M;
    static PriorityQueue<Integer> mapPos, mapNeg;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        mapPos = new PriorityQueue<>((o1, o2) -> o2 - o1);
        mapNeg = new PriorityQueue<>((o1, o2) -> o2 - o1);
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            if(cur < 0) {
                mapNeg.add(Math.abs(cur));
            }
            else {
                mapPos.add(cur);
            }
        }

        int furthest = 0;
        if(mapPos.isEmpty()) {
            furthest = mapNeg.peek();
        }
        else if(mapNeg.isEmpty()) {
            furthest = mapPos.peek();
        }
        else {
            furthest = Math.max(mapPos.peek(), mapNeg.peek());
        }

        int answer = 0;
        while(!mapNeg.isEmpty()) {
            int cur = mapNeg.poll();
            for(int i = 0; i < M - 1; i++) {
                mapNeg.poll();
                if(mapNeg.isEmpty()) break;
            }
            answer += cur * 2;
        }

        while(!mapPos.isEmpty()) {
            int cur = mapPos.poll();
            for(int i = 0; i < M - 1; i++) {
                mapPos.poll();
                if(mapPos.isEmpty()) break;
            }
            answer += cur * 2;
        }

        answer -= furthest;

        System.out.println(answer);
    }
}
