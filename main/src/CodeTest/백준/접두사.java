package CodeTest.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 접두사 {

    static List<String> list;
    static int answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            list.add(br.readLine());
        }

        list.sort((a1, a2) -> a1.length() - a2.length());

        solution();

        System.out.println(answer);

    }

    public static void solution() {

        List<String> prefixX = new ArrayList<>();

        for(int i = 0; i < list.size(); i++) {
            boolean flag = false;
            for(int j = i + 1; j < list.size(); j++) {
                String compare = list.get(j).substring(0, list.get(i).length());
                if(compare.equals(list.get(i))) {
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                prefixX.add(list.get(i));
            }
        }

        answer = prefixX.size();
    }
}
