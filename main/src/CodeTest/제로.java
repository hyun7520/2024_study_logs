package CodeTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class 제로 {
    
    static Stack<Integer> stack;
    
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        int sum = 0;
        stack = new Stack<>();
        
        for(int i = 0; i < K; i++) {
            int j = sc.nextInt();
            if(j != 0) {
                stack.add(j);
            } else {
                stack.pop();
            }
        }

        while(!stack.isEmpty()) {
            sum += stack.pop();
        }

        System.out.println(sum);
    }
}
