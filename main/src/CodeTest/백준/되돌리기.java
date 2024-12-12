package CodeTest.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
            String toDo = st.nextToken();
            String time = st.nextToken();
            inputs[i][1] = toDo;
            inputs[i][2] = time;
            map.put(time, toDo);
        }

        System.out.println(solution());

    }

    public static String solution() {
        StringBuilder sb = new StringBuilder();

        for(String[] input: inputs) {

            if(input[0].equals("type")) {
                sb.append(input[1]);
            }

        }
    }
}
