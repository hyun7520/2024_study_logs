package CodeTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 스택 {

    static List<Integer> stack;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        stack = new ArrayList<>();
        StringTokenizer st;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            stack(st);
        }
    }

    public static void stack(StringTokenizer st) {
        String command = st.nextToken();
        if(command.equals("push")) {
            int num = Integer.parseInt(st.nextToken());
            stack.add(num);
        }
        if(command.equals("top")) {
            if(stack.isEmpty()) {
                System.out.println(-1);
            } else {
                System.out.println(stack.get(stack.size() - 1));
            }
        }
        if(command.equals("size")) {
            System.out.println(stack.size());
        }
        if(command.equals("empty")) {
            if(stack.isEmpty()) {
                System.out.println(1);
            }
            else System.out.println(0);
        }
        if(command.equals("pop")) {
            if(stack.isEmpty()) {
                System.out.println(-1);
            } else {
                System.out.println(stack.get(stack.size() -1 ));
                stack.remove(stack.size() - 1);
            }
        }
    }
}
