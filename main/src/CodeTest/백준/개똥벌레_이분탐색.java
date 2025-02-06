package CodeTest.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 3020
public class 개똥벌레_이분탐색 {

    static int N, H;
    static int[] down, up;
    static int[] sumDown, sumUp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        down = new int[N / 2];
        up = new int[N / 2];

        // 석순과 종유석 순으로 장애물이 한 줄 씩 입력되며, 항상 짝수이다.
        // 2개씩 입력받아서 따로따로 저장
        for(int i = 0; i < N / 2; i++) {
            int d = Integer.parseInt(br.readLine());
            int u = Integer.parseInt(br.readLine());
            down[i] = d;
            up[i] = u;
        }

        // 종유석, 석순을 길이 순으로 오름차순 정렬해주자.
        Arrays.sort(down);
        Arrays.sort(up);

        int min = Integer.MAX_VALUE;
        int cnt = 0;

        // 높이를 모두 탐색한다.
        for(int i = 1; i <= H; i++) {

            // 개똥벌레가 i의 높이로 날아갈 경우 부숴야하는 석순의 개수
            int d = search(0, N / 2, down, i);
            // 종유석은 위에서부터 자란다.
            // 따라서, h - i + 1 이상의 길이로 자란 종유석이어야만 개똥벌레가 부수고 지나감
            int u = search(0, N / 2, up, H - i + 1);

            // 이제 i 높이에서 종유석과 석순을 부숴야하는 개수를 더해주고 min 값과 cnt 값을 갱신시키거나
            // 현재 최솟값과 같을 경우 cnt + 1을 해준다.
            if(min > d + u) {
                min = d + u;
                cnt = 1;
                continue;
            }
            if(min == d + u) {
                cnt ++;
            }
        }

        System.out.println(min + " " + cnt);
    }

    // 석순과 종유석 배열 별로 확인한다.
    // 주어진 높이(h)보다 작은 인덱스를 찾는다.
    // 찾은 인덱스보다 오른쪽(right)에 존재하는 종유석이나 석순은 더 길기 때문에 개똥벌레가 부수고 지나가야 한다.
    // 따라서 주어진 높이에서의 최소값은 전체 길이에서 right 값을 빼면 구할수 있다.
    public static int search(int left, int right, int[] cave, int h) {
        while(left < right) {
            int mid = (left + right) / 2;

            if(cave[mid] >= h) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        return cave.length - right;
    }
}
