package CodeTest.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 1092번
public class 배 {

    static List<Integer> weightLimit;
    static List<Integer> boxes;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        weightLimit = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            weightLimit.add(Integer.parseInt(st.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());
        boxes = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < m; i++) {
            boxes.add(Integer.parseInt(st.nextToken()));
        }

        weightLimit.sort(Collections.reverseOrder());
        boxes.sort(Collections.reverseOrder());

        if(boxes.get(0) > weightLimit.get(0)) {
            System.out.println(-1);
        } else {
            System.out.println(solution());
        }

    }

    public static int solution() {
        int answer = 0;

        while(!boxes.isEmpty()) {
            int craneIdx = 0, boxIdx = 0;

            while(craneIdx < weightLimit.size()) {
                if(boxIdx >= boxes.size()) {
                    break;
                }
                if (weightLimit.get(craneIdx) >= boxes.get(boxIdx)) {
                    boxes.remove(boxIdx);
                    craneIdx++;
                } else {
                    boxIdx++;
                }
            }
            answer++;
        }

        return answer;
    }
}
