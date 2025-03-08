package CodeTest.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 1062
public class 가르침 {

    static int N, K, max;
    static boolean[] read;
    static List<String> word;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        max = Integer.MIN_VALUE;
        read = new boolean[26];
        word = new ArrayList<>();

        // 배우는 글자수가 26개이면 모든 알파벳을 아므로 N 그대로 출력
        if(K == 26) {
            System.out.println(N);
            return;
        // 배우는 글자수가 5개 미만일 경우 anta, tica 2개의 필수 단어를 모름으로 0개 출력
        } else if(K < 5) {
            System.out.println(0);
            return;
        }

        read[0] = true;
        read['c' - 'a'] = true;
        read['i' - 'a'] = true;
        read['n' - 'a'] = true;
        read['t' - 'a'] = true;

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            word.add(str);
        }

        dfs(0, 0);

        System.out.println(max);
    }

    public static void dfs(int start, int len) {
        if (len == K - 5) {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                boolean canRead = true;
                for (int j = 0; j < word.get(i).length(); j++) {
                    if (!read[word.get(i).charAt(j) - 'a']) {
                        canRead = false;
                        break;
                    }
                }
                if (canRead) cnt++;
            }
            max = Math.max(cnt, max);
            return;
        }

        for(int i = 0; i < 26; i++) {
            if(!read[i]) {
                read[i] = true;
                dfs(i, len + 1);
                read[i] = false;
            }
        }
    }
}
