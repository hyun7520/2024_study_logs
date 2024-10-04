package CodeTest.카카오코테;

public class 양궁대회 {
    int[] lionScores = {-1};
    int[] temp;
    int[] apeachScores;
    int maxScoreDiff = -10000;

    public int[] solution(int n, int[] info) {

        apeachScores = info;
        temp = new int[11];

        dfs(0, n);

        return lionScores;
    }

    public void dfs(int depth, int n) {

        if(depth == n) {
            int apeach = 0;
            int lion = 0;
            for(int i = 0; i < 11; i++) {
                if(temp[i] > apeachScores[i]) {
                    lion += 10 - i;
                } else if(apeachScores[i] != 0) {
                    apeach += 10 - i;
                }
            }
            if(lion > apeach ) {
                if(maxScoreDiff <= (lion - apeach)) {
                    maxScoreDiff = lion - apeach;
                    lionScores = temp.clone();
                }
            }
            return;
        }

        for(int i = 0; i < 11 && temp[i] <= apeachScores[i]; i++) {
            temp[i]++;
            dfs(depth + 1, n);
            temp[i]--;
        }
    }
}
