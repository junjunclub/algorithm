import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        PriorityQueue<Integer> expirationTimes = new PriorityQueue<>();
        int totalServers = 0;

        for (int hour = 0; hour < 24; hour++) {
            int requiredServers = players[hour] / m;

            // 만료된 서버 제거
            while (!expirationTimes.isEmpty() && expirationTimes.peek() <= hour) {
                expirationTimes.poll();
            }

            int runningServers = expirationTimes.size();

            // 부족한 서버 추가
            if (requiredServers > runningServers) {
                int serversToAdd = requiredServers - runningServers;
                for (int s = 0; s < serversToAdd; s++) {
                    expirationTimes.add(hour + k);
                }
                totalServers += serversToAdd;
            }
        }
        return totalServers;
    }
}