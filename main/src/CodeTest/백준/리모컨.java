package CodeTest.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 리모컨 {

    static boolean[] broken;
    static int min;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        min = Math.abs(n - 100);

        if(n == 100) {
            System.out.print(0);
        } else {
            if(m > 0) {
                broken = new boolean[10];
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int i = 0; i < m; i++) {
                    broken[Integer.parseInt(st.nextToken())] = true;
                }
            } else {
                broken = new boolean[10];
            }
            System.out.print(solution(n));
        }
    }

    public static int solution(int n) {

        for(int i = 0; i <= 999999; i++) {
            String chk = String.valueOf(i);
            
            boolean flag = true;
            for(int j = 0; j < chk.length(); j++) {
                if(broken[chk.charAt(j) - '0']) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                int pushes = Math.abs(n - i) + chk.length();
                min = Math.min(min, pushes);
            }
        }

        return min;
    }
}
