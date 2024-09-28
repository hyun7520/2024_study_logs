package CodeTest.카카오코테;

import java.util.Set;
import java.util.HashSet;

// N+1 카드게임
public class N1카드게임 {
    public static void main(String[] args) {

        System.out.println(solution(4, new int[] {3, 6, 7, 2, 1, 10, 5, 9, 8, 12, 11, 4}));

        System.out.println(solution(3, new int[] {1, 2, 3, 4, 5, 8, 6, 7, 9, 10, 11, 12}));

    }

    public static int solution(int coin, int[] cards) {
        int answer = 1;

        int n = cards.length;
        int target = n + 1;
        int curIdx = n / 3;
        boolean solved;
        Set<Integer> newCards = new HashSet<>();
        Set<Integer> myCards = new HashSet<>();

        for(int i = 0; i < curIdx; i++) {
            myCards.add(cards[i]);
        }

        while(true) {

            if(curIdx >= n) break;
            newCards.add(cards[curIdx++]);
            newCards.add(cards[curIdx++]);
            solved = false;

            for(int i : myCards) {
                if(myCards.contains(target - i)) {
                    myCards.remove(i);
                    myCards.remove(target - i);
                    solved = true;
                    break;
                }
            }

            if(!solved && coin > 0) {
                for(int i : myCards) {
                    if(newCards.contains(target - i)) {
                        myCards.remove(i);
                        newCards.remove(target - i);
                        coin--;
                        solved = true;
                        break;
                    }
                }
            }

            if(!solved && coin > 1) {
                for(int i : newCards) {
                    if(newCards.contains(target - i)) {
                        newCards.remove(i);
                        newCards.remove(target - i);
                        coin -= 2;
                        solved = true;
                        break;
                    }
                }
            }

            if(!solved) {
                break;
            }

            answer++;
        }

        return answer;
    }
}
