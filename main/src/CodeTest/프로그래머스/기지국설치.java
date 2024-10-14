package CodeTest.프로그래머스;

public class 기지국설치 {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int now = 1;
        int stationIdx = 0;


        while(now < n+1) {
            if(stationIdx >= stations.length || now < stations[stationIdx] - w) {
                answer++;
                now = now + 2 * w + 1;
            } else {
                now = stations[stationIdx] + w + 1;
                stationIdx++;
            }
        }

        return answer;
    }
}
