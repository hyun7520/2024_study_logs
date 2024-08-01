package CodeTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 대칭차집합_1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int answer1, answer2;

        Set<Integer> set1 = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            set1.add(Integer.parseInt(st.nextToken()));
        }

        answer1 = set1.size();
        Set<Integer> set2 = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            int temp = Integer.parseInt(st.nextToken());
            if(set1.contains(temp)) {
                answer1--;
            }
            set2.add(temp);
        }
        answer2 = set2.size();

        for(int s : set2) {
            if(set1.contains(s)){
                answer2--;
            }
        }

        System.out.println(answer1+answer2);
    }
}
