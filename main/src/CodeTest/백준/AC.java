package CodeTest.백준;

import java.io.*;
import java.util.*;

// 5430
public class AC {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        String p;
        StringTokenizer code;
        Deque<Integer> deque;
        int n;

        for(int i = 0; i < T; i++) {

            p = br.readLine();
            n = Integer.parseInt(br.readLine());
            code = new StringTokenizer(br.readLine(), "[],");
            long cnt = p.chars().filter(ch -> ch == 'D').count();

            if(cnt > n) {
                System.out.println("error");
                continue;
            }

            deque = new ArrayDeque<>();
            while(code.hasMoreTokens()) {
                deque.add(Integer.parseInt(code.nextToken()));
            }

            solution(p, deque);
        }
    }

    public static void solution(String p, Deque<Integer> deque) throws IOException {

        boolean isReverse = false;

        for(char c : p.toCharArray()) {
            if(c == 'D' && !isReverse) {
                deque.pollFirst();
            }
            if(c == 'D' && isReverse) {
                deque.pollLast();
            }
            if(c == 'R') {
                isReverse = !isReverse;
            }
        }

        printAnswer(isReverse, deque);
    }

    public static void printAnswer(boolean isReverse, Deque<Integer> deque) {

        StringBuilder sb = new StringBuilder();

        sb.append("[");

        if(!deque.isEmpty()) {
            if(isReverse) {
                sb.append(deque.pollLast());
                while(!deque.isEmpty()) {
                    sb.append(",").append(deque.pollLast());
                }
            }
            else {
                sb.append(deque.pollFirst());
                while(!deque.isEmpty()) {
                    sb.append(",").append(deque.pollFirst());
                }
            }
        }
        sb.append("]");
        System.out.println(sb);
    }
}
