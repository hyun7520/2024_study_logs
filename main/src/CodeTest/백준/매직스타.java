package CodeTest.백준;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// 3967
public class 매직스타 {

    // 전체 그림을 담을 배열
    static char[][] star = new char[5][9];;
    // x의 위치정보를 저장하는 리스트
    static List<Node> nodes = new ArrayList<>();
    // A에서 L까지 알파벳이 사용되었는지 여부를 확인할 boolean 배열
    static boolean[] used =  new boolean[12];

    static class Node {
        private int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 5; i++) {
            String str = br.readLine();
            for(int j = 0; j < 9; j++) {
                // 입력을 받으면서 'x'일 경우와 아닌 경우
                star[i][j] = str.charAt(j);
                // x일 경우 채워넣어야 하므로 nodes에 좌표 정보를 저장
                if(star[i][j] == 'x') {
                    nodes.add(new Node(i, j));
                }
                // x도 아니고 .도 아닐 경우 알파벳으로 채워진 부분
                // 이미 사용되었음을 표시하자.
                else if(star[i][j] != '.') {
                    used[star[i][j] - 65] = true;
                }
            }
        }

        // nodes 0번째 인덱스부터 탐색 시작
        dfs(0);
    }

    public static void dfs(int idx) {

        // 종료 조건 => 전부 탐색이 끝났을 때 == 모든 x가 채워졌을 때
        if(idx == nodes.size()) {
            if(check()) {
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i < 5; i++) {
                    for(int j = 0; j < 9; j++) {
                        sb.append(star[i][j]);
                    }
                    sb.append("\n");
                }
                System.out.print(sb);
                // 정답은 사전순으로 가장 빠른 것
                // A ~ L 순으로 탐색하기 때문에 가장 먼저 조건을 만족하는 답을 출력하고 종료해야 한다.
                // 종료를 안할 경우 사전순 가장 마지막 답을 출력하거나 무한루프를 돈다.
                // TODO: 무한루프 도는 이유 알아보기
                System.exit(0);
            }
            else {
                return;
            }
        }

        // A ~ L 까지 확인 시작
        for(int i = 0; i < 12; i++) {
            // 현재 알파벳이 아직 사용되지 않았을 경우
            if(!used[i]) {
                // 위치 정보를 받아오고
                Node cur = nodes.get(idx);
                // 사용됐다고 표시하고
                used[i] = true;
                // 그림 상 알파벳을 입력해주고
                star[cur.x][cur.y] = (char) (i + 'A');
                // 다음 빈칸으로 이동
                dfs(idx + 1);
                // 그 다음 루프를 위해 조건 초기화
                used[i] = false;
                star[cur.x][cur.y] = '.';
            }
        }
    }

    // 출처: https://suhyeokeee.tistory.com/112
    // 숫자 확인 조건
    public static boolean check() {

        int sum1 = (star[0][4]-'A'+1)+(star[1][3]-'A'+1)+(star[2][2]-'A'+1)+(star[3][1]-'A'+1);
        int sum2 = (star[0][4]-'A'+1)+(star[1][5]-'A'+1)+(star[2][6]-'A'+1)+(star[3][7]-'A'+1);
        int sum3 = (star[1][1]-'A'+1)+(star[1][3]-'A'+1)+(star[1][5]-'A'+1)+(star[1][7]-'A'+1);
        int sum4 = (star[3][1]-'A'+1)+(star[3][3]-'A'+1)+(star[3][5]-'A'+1)+(star[3][7]-'A'+1);
        int sum5 = (star[4][4]-'A'+1)+(star[3][3]-'A'+1)+(star[2][2]-'A'+1)+(star[1][1]-'A'+1);
        int sum6 = (star[4][4]-'A'+1)+(star[3][5]-'A'+1)+(star[2][6]-'A'+1)+(star[1][7]-'A'+1);

        return sum1 == 26 && sum2 == 26 && sum3 == 26 && sum4 == 26 && sum5 == 26 && sum6 == 26;
    }
}
