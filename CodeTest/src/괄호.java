import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 괄호 {

    static Stack<Character> stack;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            stack = new Stack<>();
            String s = br.readLine();
            for(int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if(c == '(') {
                    stack.add(c);
                }
                else if(c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.add(c);
                }
            }
            if(stack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
