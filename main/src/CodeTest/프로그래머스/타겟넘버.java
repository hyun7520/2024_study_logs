package CodeTest.프로그래머스;

public class 타겟넘버 {

    public static void main(String[] args) {

        int[] numbers = {1, 1, 1, 1, 1};

        타겟넘버Solution sol = new 타겟넘버Solution();

        System.out.println(sol.solution(numbers, 3));
    }
}

class 타겟넘버Solution {

    static int count;
    int sum;

    public int solution(int[] numbers, int target) {
        count = 0;
        sum = 0;

        DFS(0, numbers, target, 0);

        return count;
    }

    int DFS(int depth, int[] numbers, int target, int sum) {

        if(depth == numbers.length) {
            if (target == sum) {
                count++;
            }
        } else {
            DFS(depth + 1, numbers, target, sum - numbers[depth]);
            DFS(depth + 1, numbers, target, sum + numbers[depth]);
        }

        return count;
    }
}
