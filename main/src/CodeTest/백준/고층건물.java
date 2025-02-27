package CodeTest.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1027
public class 고층건물 {

    static int N;
    static int[] heights;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        heights = new int[N];
        int answer = 0;

        // 건물의 높이를 저장
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        // 각 건물마다 기울기 차이를 탐색한다.
        // y = ax
        // 현재 건물 기준 좌측 건물들은 기울기(a)가 감소해야 보인다. (기울기가 3일 경우 1이면 보인다.)
        // 반대로 우측에 있는 건물들은 기울기가 증가해야 건물이 보인다. (기울기가 -3일 경우 -1이면 보인다.)
        for(int i = 0; i < N; i++) {
            answer = Math.max(answer, solution(i));
        }

        System.out.println(answer);
    }

    public static int solution(int idx) {

        int cnt = 0;
        // 기준 건물과 현재 탐색중인 건물의 기울기를 저장
        // 좌측 탐색 시 기울기가 현재 기울기 보다 더 크다면 보이지 않는다.
        // 우측은 그 반대
        double temp = 0;

        for(int i = idx - 1; i >= 0; i--) {
            double gradient = (double) (heights[idx] - heights[i]) / (idx - i);

            if(i == idx - 1 || temp > gradient) {
                cnt++;
                temp = gradient;
            }
        }

        for(int i = idx + 1; i < N; i++) {
            double gradient = (double) (heights[idx] - heights[i]) / (idx - i);

            if(i == idx + 1 || temp < gradient) {
                cnt++;
                temp = gradient;
            }
        }

        return cnt;
    }
}
