package CodeTest.프로그래머스;

public class N진수게임 {

    public static void main(String[] args) {

        N진수게임Solution sol = new N진수게임Solution();

        System.out.println(sol.solution(2, 4, 2, 1));
    }
}

class N진수게임Solution {
    public String solution(int n, int t, int m, int p) {

        StringBuilder convert = new StringBuilder();
        StringBuilder answer = new StringBuilder();

        for(int i = 0; convert.length() < t * m; i++) {
            convert.append(Integer.toString(i, n));
        }

        for(int i = p - 1; answer.length() < t; i += m) {
            answer.append(convert.charAt(i));
        }

        return answer.toString().toLowerCase();
    }
}