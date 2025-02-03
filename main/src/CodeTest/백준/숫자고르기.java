package CodeTest.백준;


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 2668
public class 숫자고르기 {

    static int N;
    static int[] arr;
    static boolean[] visited;
    static List<Integer> answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        answer = new ArrayList<>();

        arr = new int[N + 1];
        visited = new boolean[N + 1];
        answer = new ArrayList<>();

        for(int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }


        for(int i = 1; i < N + 1; i++) {
            visited[i] = true;
            checkCycle(i, i);
            visited[i] = false;
        }

        Collections.sort(answer);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(answer.size() + "\n");
        for(int answer: answer) {
            bw.write(answer + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void checkCycle(int cur, int check) {

        if(!visited[arr[cur]]) {
            visited[arr[cur]] = true;
            checkCycle(arr[cur], check);
            visited[arr[cur]] = false;
        }
        if(arr[cur] == check) {
            answer.add(check);
        }
    }
}
