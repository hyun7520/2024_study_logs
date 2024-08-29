package CodeTest.프로그래머스;

public class 네트워크 {
    public static void main(String[] args) {

        네트워크Solution sol = new 네트워크Solution();

        int[][] computers = { {1, 1, 0}, {1, 1, 0}, {0, 0 ,1} };

        System.out.println(sol.solution( 3, computers));

    }
}

class 네트워크Solution {

    public int solution(int n, int[][] computers) {
        int answer = 0;

        boolean[] visit = new boolean[computers.length];

        for(int i = 0; i < computers.length; i++) {
            if(!visit[i]) {
                answer++;
                DFS(i, computers, visit);
            }
        }

        return answer;
    }

    public void DFS(int start, int[][] computers, boolean[] visit) {

        visit[start] = true;
        for(int i = 0; i < computers.length; i++) {
            if(!visit[i] && computers[start][i] == 1) {
                DFS(i, computers, visit);
            }
        }
    }
}