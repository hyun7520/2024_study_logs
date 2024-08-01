package CodeTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 이다솜_1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> mapS = new HashMap<>();
        Map<Integer, String> mapI = new HashMap<>();

        for(int i = 1; i <= N; i++) {
            String pokemon = br.readLine();
            mapS.put(pokemon, i);
            mapI.put(i, pokemon);
        }

        for(int i = 0; i < M; i++) {
            String q = br.readLine();
            if((int) q.charAt(0) >= 65 && (int) q.charAt(0) <= 90) {
                System.out.println(mapS.get(q));
            } else {
                System.out.println(mapI.get(Integer.parseInt(q)));
            }
        }
    }
}
