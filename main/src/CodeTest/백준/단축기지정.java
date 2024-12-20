package CodeTest.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class 단축기지정 {

    static String[] str;
    static Set<Character> shortCuts;
    static String[] outputs;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        str = new String[n];
        shortCuts = new HashSet<>();
        outputs = new String[str.length];

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

        for(int i = 0; i < str.length; i++) {
            split = str[i].split(" ");
            flag = false;

            for(int j = 0; j < split.length; j++) {
                if(!shortCuts.contains(split[j].charAt(0))) {
                    shortCuts.add(Character.toUpperCase(split[j].charAt(0)));
                    doOutPut(str[i], 0);
                    flag = true;
                }

                if(flag) {
                    break;
                }
            }

            if(flag) {
                continue;
            } else {
                for(int j = 0; j < split.length; j++) {
                    flag = false;
                    for(int k = 0; k < split[i].length(); k++) {
                        if(!shortCuts.contains(split[i].charAt(k))) {
                            shortCuts.add(Character.toUpperCase(split[i].charAt(k)));
                            doOutPut(str[i], k);
                            flag = true;
                        }
                    }
                    if(flag) {
                        continue;
                    }
                }
            }

        }
    }

    public static void doOutPut(String str, int idx) {

        StringBuilder sb = new StringBuilder(str);
        if(idx == 0) {
            sb.insert(0, '[');
            sb.insert(2, ']');
            outputs[idx] = sb.toString();
        } else {
            sb.insert(idx - 1, '[');
            sb.insert(idx + 1, ']');
            outputs[idx] = sb.toString();
        }
    }
}
