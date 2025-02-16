package CodeTest.백준;

import java.io.*;
import java.util.Arrays;

// 3649
public class 로봇프로젝트 {

    static int hole;
    static int legos;
    static int[] pieces;
    static int answer1, answer2;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";

        while((str = br.readLine()) != null && !str.isEmpty()) {
            hole = Integer.parseInt(str) * 10000000;
            legos = Integer.parseInt(br.readLine());
            pieces = new int[legos];

            for(int i = 0; i < legos; i++) {
                pieces[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(pieces);
            boolean flag = binSearch();

            if(!flag) {
                System.out.println("danger");
            }
            else {
                System.out.printf("yes %d %d\n", answer1, answer2);
            }
        }
    }

    public static boolean binSearch() {

        int left = 0;
        int right = legos - 1;

        while(left < right) {

            int cur = pieces[left] + pieces[right];

            if(cur == hole) {
                answer1 = pieces[left];
                answer2 = pieces[right];
                return true;
            }
            else if(cur < hole) {
                left++;
            }
            else {
                right--;
            }
        }

        return false;
    }
}
