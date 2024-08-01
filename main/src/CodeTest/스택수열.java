package CodeTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 스택수열 {

    static Stack<Integer> stack, temp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n =Integer.parseInt(br.readLine());
        boolean flag = true;

        stack = new Stack<>();
        temp = new Stack<>();

        for(int i = 0; i < n; i++) {
            int now = Integer.parseInt(br.readLine());
            sb.append(now);
            stack.push(n - i);
        }

        String answer = sb.toString();
        sb = new StringBuilder();

        while(!sb.toString().equals(answer) || !stack.isEmpty()) {

            int current = Character.getNumericValue(answer.charAt(answer.length() - 1));

            if(stack.peek() == current) {
                stack.pop();
                continue;
            }
            if(stack.peek() != current && temp.isEmpty()) {
                temp.push(stack.pop());
                continue;
            }


        }

        if(!flag) {
            System.out.println("NO");
        }
    }
}
//  end       start
//  1 2 3 4 5 6 7 8    4 3 6 8 7 5 2 1
//  1
//  1 2
//  1 2 3
//  1 2 3 4
//  1 2 3               4
//  1 2                 4 3
//  1 2 5
//  1 2 5 6
//  1 2 5               4 3 6
//  1 2 5 7
//  1 2 5 7 8

