package CodeTest.프로그래머스;

import java.util.Queue;
import java.util.LinkedList;

public class 다리를지나는트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int maxWeight = 0;
        int time = 0;

        Queue<Integer> queue = new LinkedList<>();

        for(int truck : truck_weights) {

            while(true) {
                if(queue.isEmpty()) {
                    queue.add(truck);
                    maxWeight += truck;
                    time++;
                    break;
                }
                else if(queue.size() == bridge_length) {
                    maxWeight -= queue.poll();
                } else {
                    if(maxWeight + truck <= weight) {
                        queue.add(truck);
                        maxWeight += truck;
                        time++;
                        break;
                    } else {
                        queue.add(0);
                        time++;
                    }
                }
            }
        }


        return time + bridge_length;
    }
}
