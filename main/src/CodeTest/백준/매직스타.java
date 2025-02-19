package CodeTest.백준;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class 매직스타 {

    static int[][] star;
    static List<Integer> magic;
    static boolean[] used;
    static boolean[] input;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        star = new int[5][9];
        magic = new ArrayList<>();
        used = new boolean[12];
        input = new boolean[12];

        for(int i = 0; i < 5; i++) {
            String str = br.readLine();
            for(int j = 0; j < 9; j++) {
                char c = str.charAt(j);
                if(c == 'x') {
                    magic.add(0);
                }
                else if(c != '.') {
                    magic.add(c - 'A' + 1);
                    used[c - 'A'] = true;
                }
                star[i][j] = c;
            }
        }

        dfs(0);
    }

    public static void dfs(int idx) throws IOException {

        if(idx == 11) {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int idx2 = 0;
            for(int i = 0; i < 5; i++) {
                for(int j = 0; j < 9; j++) {
                    if(star[i][j] == 'x') {
                        bw.write(magic.get(idx2));
                        idx2++;
                        continue;
                    }
                    bw.write(star[i][j]);
                }
                bw.write("\n");
            }
            bw.flush();
            bw.close();
        }

        for(int i = 0; i < 12; i++) {
            if(!used[i]) {
                magic.set(i, i + 'A' + 1);
                used[i] = true;
                dfs(idx + 1);
                magic.set(i, 0);
                used[i] = false;
            }
        }
    }

    public static boolean check() {
        int sum1 = magic.get(0) + magic.get(3) + magic.get(9) + magic.get(10);
        int sum2 = magic.get(10) + magic.get(4) + magic.get(2) + magic.get(6);
        int sum3 = magic.get(6) + magic.get(5) + magic.get(11) + magic.get(0);
        int sum4 = magic.get(1) + magic.get(9) + magic.get(4) + magic.get(8);
        int sum5 = magic.get(8) + magic.get(2) + magic.get(5) + magic.get(7);
        int sum6 = magic.get(7) + magic.get(11) + magic.get(3) + magic.get(1);

        return sum1 == 26 && sum2 == 26 && sum3 == 26 && sum4 == 26 && sum5 == 26 && sum6 == 26;
     }
}
