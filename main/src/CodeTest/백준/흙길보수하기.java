package CodeTest.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// 1911
public class 흙길보수하기 {

    // N - 웅덩이 개수, L - 널빤지의 길이
    static int N, L;
    static int[][] puddles;
    static int answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        puddles = new int[N][2];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            puddles[i][0] = Integer.parseInt(st.nextToken());
            puddles[i][1] = Integer.parseInt(st.nextToken());;
        }

        Arrays.sort(puddles, Comparator.comparingInt((int[] a) -> a[0]));
        
        // 현재 덮힌 위치 중 가장 끝
        int covered = 0;
        // 웅덩이를 덮고 남은 널빤지의 길이
        int remain;

        for(int i = 0; i < puddles.length; i++) {
            
            // 덮어야할 웅덩이의 마지막 위치를 비교
            // covered 보다 작다면 이미 덮여진 위치임으로 다음 웅덩이로
            if(puddles[i][1] < covered) {
                continue;
            }

            // 덮여진 웅덩이가 아니라면 시작점을 먼저 덮는다.
            if(covered < puddles[i][0]) {
                covered = puddles[i][0];
            }

            // 웅덩이를 덮기 위해 사용한 널판지의 갯수 구하기
            answer += (puddles[i][1] - covered) / L;
            // 덮고 남은 널빤지의 길이 구하기
            remain = (puddles[i][1] - covered) % L;
            // 형재 웅덩이의 가장 끝을 덮어진 지점으로 저장한다.
            covered = puddles[i][1];

            // 널판지가 남았을 경우 덮어진 위치를 널판지가 남은 만큼 더 더해준다.
            if(remain > 0) {
                answer++;
                covered += L - remain;
            }

        }

        System.out.println(answer);
    }
}
