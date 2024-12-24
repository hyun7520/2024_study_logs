package CodeTest.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 단축기지정 {

    static String[] str;
    static Set<Character> shortCuts;
    static List<String> outputs;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        str = new String[n];
        outputs = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            String st = br.readLine();
            str[i] = st;
        }

        solution();

        for(String output: outputs) {
            System.out.println(output);
        }
    }

    public static void solution() {

        String[] split;
        boolean flag;
        shortCuts = new HashSet<>();

        for (String str : str) {
            split = str.split(" ");
            flag = false;
            int idx = 0;

            for (String s : split) {
                if (!shortCuts.contains(s.charAt(0))) {
                    shortCuts.add(Character.toUpperCase(s.charAt(0)));
                    shortCuts.add(Character.toLowerCase(s.charAt(0)));
                    doOutPut(str, idx);
                    flag = true;
                }
                if (flag) {
                    break;
                }
                idx += s.length() + 1;

            }

            if (flag) {
                continue;
            }

            for(int i = 0; i < str.length(); i++) {
                if(!shortCuts.contains(str.charAt(i)) && str.charAt(i) != ' ') {
                    shortCuts.add(Character.toUpperCase(str.charAt(i)));
                    shortCuts.add(Character.toLowerCase(str.charAt(i)));
                    doOutPut(str, i);
                    flag = true;
                }
                if (flag) {
                    break;
                }
            }

            if(!flag) {
                outputs.add(str);
            }
        }

    }

    public static void doOutPut(String option, int idx) {

        StringBuilder sb = new StringBuilder(option);
        if(idx == 0) {
            sb.insert(0, '[');
            sb.insert(2, ']');
        } else {
            sb.insert(idx, '[');
            sb.insert(idx + 2, ']');
        }
        outputs.add(sb.toString());
    }
}