package CodeTest.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 되돌리기 {

    static String[][] inputs;
    static Map<String, String> map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        inputs = new String[n][3];
        StringTokenizer st;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            inputs[i][0] = st.nextToken();
            inputs[i][1] = st.nextToken();
            inputs[i][2] = st.nextToken();
        }

        System.out.println(solution());

    }

    public static String solution() {
        StringBuilder sb = new StringBuilder();

        String[][] time = new String[inputs.length + 1][2];

        for (int i = 0; i < inputs.length; i++) {
            if (inputs[i][0].equals("type")) {
                sb.append(inputs[i][1]);
                time[i+1][0] = inputs[i][2];
                time[i+1][1] = sb.toString();
            }
            if (inputs[i][1].equals("undo")) {
                String cur = time[Integer.parseInt(inputs[i][2]) - Integer.parseInt(inputs[i][1])][1];
                time[i+1][0] = inputs[i][2];
                time[i+1][1] = cur;
                sb.setLength(0);
                sb.append(cur);
            }
        }

        return time[time.length - 1][1];
    }
}
