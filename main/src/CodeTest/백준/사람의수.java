package CodeTest.백준;

import java.io.*;

public class 사람의수 {

    static int n;
    static Double[] avg;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        avg = new Double[n];

        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            avg[i] = Double.parseDouble(str) * 1000;
        }

        for(int i = 1; i < 1001; i++) {
            if(solution(i)) {
                bw.write(i + "");
                break;
            }
        }

        bw.flush();
        bw.close();
    }

    public static boolean solution(int people) {

        int left, right, mid;
        double curAvg;
        boolean possible;

        for(double item : avg) {

            left = 0;
            right = people * 10;
            possible = false;

            while(left <= right) {
                mid = (left + right) / 2;
                curAvg = (double) mid / people * 1000;

                if(curAvg > item) {
                    right = mid - 1;
                }
                else if(curAvg < item) {
                    left = mid + 1;
                }
                else if(curAvg == item) {
                    if(curAvg > 10 * 1000) {
                        continue;
                    }
                    possible = true;
                    break;
                }
            }
            if(!possible) {
                return false;
            }
        }
        return true;
    }
}
