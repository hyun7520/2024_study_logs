import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 듣보잡_1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<String> arr = new ArrayList<>();

        Set<String> map = new HashSet<>();

        for(int i = 0; i < N; i++) {
            map.add(br.readLine());
        }

        for(int i = 0; i < M; i++) {
            String temp = br.readLine();
            if(map.contains(temp)) {
                arr.add(temp);
            }
        }

        Collections.sort(arr);

        System.out.println(arr.size());
        for(String s : arr) {
            System.out.println(s);
        }

    }
}
