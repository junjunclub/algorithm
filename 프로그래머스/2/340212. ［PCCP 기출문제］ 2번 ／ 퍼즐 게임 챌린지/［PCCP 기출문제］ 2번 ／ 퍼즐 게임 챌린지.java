class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int s = 1;
        int e = 0;
        for (int i = 0; i < diffs.length; i++) {
            e = Math.max(diffs[i], e);
        }
        
        while (s <= e) {
            answer = (s + e) / 2;
            long sumV = 0;
            
            for (int i = 0; i < diffs.length; i++) {
                if (answer >= diffs[i]) {
                    sumV += times[i];
                } else {
                    int cnt = diffs[i] - answer;
                    int retry = (i == 0) ? 0 : times[i-1];
                    
                    sumV += (long) cnt * (times[i] + retry) + times[i];
                }
                
                if (sumV > limit) break;
            }
            
            // 시간의 합이 제한시간보다 크면
            if (sumV > limit) {
                s = answer + 1;
            } else {
                e = answer - 1;
            }
        }
        
        return s;
    }
}