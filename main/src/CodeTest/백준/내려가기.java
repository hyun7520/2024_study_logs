package CodeTest.백준;

import java.io.*;
import java.util.StringTokenizer;

// 2096
// dp[][] 배열로 풀 경우 메모리 제한으로 인해 오답
// 슬라이딩 윈도우 기법을 사용하여 풀이해야 함
public class 내려가기 {

    static int N;
    static int[] dpMax;
    static int[] dpMin;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dpMax = new int[3];
        dpMin = new int[3];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int t1 = Integer.parseInt(st.nextToken());
        int t2 = Integer.parseInt(st.nextToken());
        int t3 = Integer.parseInt(st.nextToken());
        dpMax[0] = dpMin[0] = t1;
        dpMax[1] = dpMin[1] = t2;
        dpMax[2] = dpMin[2] = t3;

        for(int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            t1 = Integer.parseInt(st.nextToken());
            t2 = Integer.parseInt(st.nextToken());
            t3 = Integer.parseInt(st.nextToken());

            int prevMax0 = dpMax[0]; int prevMax1 = dpMax[1]; int prevMax2 = dpMax[2];
            dpMax[0] = Math.max(prevMax0, prevMax1) + t1;
            dpMax[1] = Math.max(prevMax0, Math.max(prevMax1, prevMax2)) + t2;
            dpMax[2] = Math.max(prevMax1, prevMax2) + t3;

            int prevMin0 = dpMin[0]; int prevMin1 = dpMin[1]; int prevMin2 = dpMin[2];
            dpMin[0] = Math.min(prevMin0, prevMin1) + t1;
            dpMin[1] = Math.min(prevMin0, Math.min(prevMin1, prevMin2)) + t2;
            dpMin[2] = Math.min(prevMin1, prevMin2) + t3;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(Math.max(dpMax[0], Math.max(dpMax[1], dpMax[2])) + " ");
        bw.write(String.valueOf(Math.min(dpMin[0], Math.min(dpMin[1], dpMin[2]))));
        bw.flush();
        bw.close();
    }
}
