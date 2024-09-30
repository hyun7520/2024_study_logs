package CodeTest.카카오코테;

import java.util.Arrays;

public class 이모티콘할인행사 {

    static int maxSubs = 0, maxIncome = 0;

    public static void main(String[] args) {

        System.out.println(Arrays.toString(solution(
                new int[][] {{40, 10000}, {25, 10000}},
                new int[] {7000, 9000}))
        );

    }

    public static int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];

        int[] ratesComb = new int[emoticons.length];

        comb(ratesComb, 0, users, emoticons);

        answer[0] = maxSubs;
        answer[1] = maxIncome;

        return answer;
    }

    public static void comb(int[] ratesComb, int start, int[][] users, int[] emoticons) {
        if(start == emoticons.length) {
            doCal(ratesComb, users, emoticons);
            return;
        }

        for(int i = 10; i <= 40; i += 10) {
            ratesComb[start] = i;
            comb(ratesComb, start + 1, users, emoticons);
        }
    }

    public static void doCal(int[] ratesComb, int[][] users, int[] emoticons) {

        int subs = 0;
        int income = 0;

        for(int[] user : users) {
            int discount = user[0];
            int priceLimit = user[1];
            int sum = 0;

            for(int i = 0; i < emoticons.length; i++) {
                if(ratesComb[i] >= discount) {
                    sum += emoticons[i] - (emoticons[i]*ratesComb[i]/100);
                }
            }

            if(sum >= priceLimit) {
                subs++;
            } else {
                income += sum;
            }
        }

        if(subs > maxSubs) {
            maxSubs = subs;
            maxIncome = income;
        }
        else if(subs == maxSubs) {
            maxIncome = Math.max(income, maxIncome);
        }
    }
}
