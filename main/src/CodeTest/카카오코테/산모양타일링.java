package CodeTest.카카오코테;


// TODO: 수정
public class 산모양타일링 {
    public static void main(String[] args) {

        System.out.println(solution(4, new int[]{1, 1, 0, 1}));
        System.out.println(solution(2, new int[]{0, 1}));
    }

    public static int solution(int n, int[] tops) {

        int[] dpA = new int[n+1];
        int[] dpB = new int[n+1];

        dpA[1] = 1;
        dpB[1] = tops[0] == 1 ? 3 : 2;

        for(int i = 2; i <= n; i++) {
            dpA[i] = (dpA[i - 1] + dpB[i - 1]) % 10007;
            if(tops[i - 1] == 1) {
                dpB[i] = (dpA[i - 1] * 2 + dpB[i - 1] * 3) % 10007;
            } else {
                dpB[i] = (dpA[i - 1] + dpB[i - 1] * 2) & 10007;
            }
        }

        return (dpA[n] + dpB[n]) % 10007;
    }
}
