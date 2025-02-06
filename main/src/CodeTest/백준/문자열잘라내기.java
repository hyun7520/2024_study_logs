package CodeTest.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 2866
public class 문자열잘라내기 {

    static int R, C;
    static char[][] arr;
    static int cnt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];

        for(int i = 0; i < R; i++) {
            String temp = br.readLine();
            for(int j = 0; j < C; j++) {
                arr[i][j] = temp.charAt(j);
            }
        }

        solution();

        System.out.println(cnt);
    }

    public static void solution() {

        int start = 0;
        int end = R - 1;

        while(start <= end) {
            int mid = (start + end) / 2;
            // check를 돌면서 중복이 발견되면 탐색할 행을 줄여야한다.
            if(check(mid)) {
                start = mid + 1;
            }
            // 아닐 경우 중복이 발견 될 때까지 중간값을 늘리기 위해 end + 1
            else {
                end = mid - 1;
            }
        }
        cnt = start;
    }

    public static boolean check(int mid) {

        Set<String> set = new HashSet<>();

        // 첫번째 열부터 탐색 시작
        for(int i = 0; i < C; i++) {
            StringBuilder sb = new StringBuilder();
            // (0, mid + 1), (0, mid + 2), (1, mid + 3) ...
            // StringBuilder에 현재 열의 mid + 1번째 char를 더해가며 set에 넣는다.
            for(int j = mid + 1; j < R; j++) {
                sb.append(arr[j][i]);
            }
            // 두번째 루프부터 바로 다음 열의 문자열을 탐색하면서 중복이 있다면 false
            if(set.contains(sb.toString())) {
                return false;
            }
            set.add(sb.toString());
        }
        return true;
    }
}
