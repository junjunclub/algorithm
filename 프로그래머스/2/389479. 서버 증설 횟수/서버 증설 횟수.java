import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        Queue<Integer> q = new LinkedList<>();
        int answer = 0;
        for (int i = 0; i < 24; i++) {
            int need = players[i] / m;
            
            while (!q.isEmpty() && q.peek() <= i) {
                q.poll();
            }
            
            int current = q.size();
            
            if (need > current) {
                int newServer = need - current;
                
                for (int j = 0; j < newServer; j++) {
                    q.add(i + k);
                    answer++;
                }
            }
        }
        return answer;
    }
}