package CodeTest.프로그래머스;

import java.util.*;

public class 베스트앨범 {

    class Solution {
        public int[] solution(String[] genres, int[] plays) {
            List<Integer> answerTemp = new ArrayList<>();

            Map<String, Integer> genre = new HashMap<>();
            Map<String, HashMap<Integer, Integer>> songs = new HashMap<>();

            for(int i = 0; i < genres.length; i++) {
                genre.put(genres[i], genre.getOrDefault(genres[i], 0) + plays[i]);
                if(!songs.containsKey(genres[i])) {
                    HashMap<Integer, Integer> map = new HashMap<>();
                    map.put(i, plays[i]);
                    songs.put(genres[i], map);
                } else {
                    songs.get(genres[i]).put(i, plays[i]);
                }
            }

            List<String> keys = new ArrayList<>(genre.keySet());
            keys.sort((a1, a2) -> genre.get(a2) - genre.get(a1));

            for(String key : keys) {
                HashMap<Integer, Integer> temp = songs.get(key);
                List<Integer> tempKeys = new ArrayList<>(temp.keySet());
                tempKeys.sort((a1, a2) -> temp.get(a2) - temp.get(a1));

                answerTemp.add(tempKeys.get(0));
                if(tempKeys.size() > 1) {
                    answerTemp.add(tempKeys.get(1));
                }
            }

            int[] answer = new int[answerTemp.size()];

            for(int i = 0; i < answerTemp.size(); i++) {
                answer[i] = answerTemp.get(i);
            }

            return answer;
        }
    }
}
