import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int N = friends.length;
        Map<String, Integer> map = new HashMap<>();
        int[][] list = new int[N][N];
        
        for (int i = 0; i < friends.length; i++) {
            map.put(friends[i], 0);
        }
        
        for (int i = 0; i < gifts.length; i++) {
            String[] gift = gifts[i].split(" ");
            String giver = gift[0];
            String taker = gift[1];
            
            int idx1 = Arrays.asList(friends).indexOf(giver);
            int idx2 = Arrays.asList(friends).indexOf(taker);
            
            list[idx1][idx2]++;
            
            map.put(giver, map.get(giver) + 1);
            map.put(taker, map.get(taker) - 1);
        }
        
        List<String> keySet = new ArrayList<>(map.keySet());
        for (int i = 0; i < N; i++) {
            int temp = 0;
            for (int j = 0; j < N; j++) {
                // System.out.print(list[i][j]);
                // System.out.print(" ");
                if (i == j) continue;
                
                // 선물을 주고 받지 않았을 경우
                if (list[i][j] == 0 && list[j][i] == 0 || list[i][j] == list[j][i]) {
                    // 선물 지수가 더 클 경우
                    if (map.get(friends[i]) > map.get(friends[j])) {
                        temp++;
                    }
                } else {
                    if (list[i][j] > list[j][i]) {
                        temp++;
                    }
                }
                answer = Math.max(temp, answer);
            }
        }
        
        return answer;
    }
}