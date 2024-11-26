package CodeTest.백준;

import java.util.*;

public class 줄어드는수 {

    static int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    static List<Long> nums = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        dfs(0, 0);
        Collections.sort(nums);

        if(nums.size() < n) {
            System.out.println(-1);
        } else {
            System.out.println(nums.get(n - 1));
        }
    }

    public static void dfs(long num, int idx) {
        if(!nums.contains(num)) {
            nums.add(num);
        }

        if(idx > 9) return;

        dfs((num * 10) + arr[idx], idx + 1);
        dfs(num, idx + 1);

    }
}
