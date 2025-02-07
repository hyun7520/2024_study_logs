package CodeTest.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//3020
public class 개똥벌레_누적합 {

    static int N, H;
    static int[] down, up;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        down = new int[H + 2];
        up = new int[H + 2];

        for(int i = 0; i < N / 2; i++) {
            int d = Integer.parseInt(br.readLine());
            // d - 아래서부터 자라는 석순
            // u - 위에서부터 자라는 종유석
            int u = H - Integer.parseInt(br.readLine()) + 1;
            // 종유석의 경우 개똥벌레가 비행 시 부숴지는 최소 높이를 저장

            down[d]++;
            up[u]++;
        }

        for(int i = 1; i < down.length; i++) {
            down[i] = down[i] + down[i - 1];
        }

        for(int i = H; i >= 1; i--) {
            up[i] = up[i] + up[i + 1];
        }

        int count = 0;
        int min = Integer.MAX_VALUE;

        for(int i = 1; i < H + 1; i++) {

            int cal = down[H] - down[i - 1] + up[1] - up[i + 1];

            if(cal < min) {
                min = cal;
                count = 1;
            }
            else if(cal == min) {
                count++;
            }

        }

        System.out.println(min + " " + count);
    }
}
