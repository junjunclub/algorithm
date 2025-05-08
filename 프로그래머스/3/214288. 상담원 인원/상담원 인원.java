import java.util.*;

class Solution {
    static int[] arr;
    static int N, K, answer;
    public int solution(int k, int n, int[][] reqs) {
        N = n;
        K = k;
        answer = Integer.MAX_VALUE;
        /**
        1. 조합으로 경우의 수를 만든다.
        2. 해당 조합으로 순회하면서 최솟값을 구한다.
        */
        
        arr = new int[k];
        Arrays.fill(arr, 1);
        
        comb(0, 0, reqs);
        
        return answer;
    }
    
    private void comb(int idx, int cnt, int[][] reqs) {
        if (cnt == N - K) {
            System.out.println(Arrays.toString(arr));
            calculate(arr, reqs);
            return;
        }
        
        for (int i = idx; i < K; i++) {
            arr[i]++;
            comb(i, cnt+1, reqs);
            arr[i]--;
        }
    }
    
    private void calculate(int[] arr, int[][] reqs) {
        int temp = 0;
        Queue<Participant>[] pq = new PriorityQueue[K + 1];

        // 각 카테고리별 PriorityQueue 초기화 (end 시간 오름차순 기준)
        for (int i = 0; i <= K; i++) {
            pq[i] = new PriorityQueue<>();
        }

        for (int i = 0; i < reqs.length; i++) {
            int reqStart = reqs[i][0];
            int duration = reqs[i][1];
            int category = reqs[i][2];
            int idx = category - 1;

            // 1. 끝난 상담 제거
            while (!pq[category].isEmpty() && pq[category].peek().end <= reqStart) {
                pq[category].poll();
            }

            int startTime = reqStart;

            // 2. 상담원이 꽉 차 있으면 가장 빨리 끝나는 상담 끝나고 시작
            if (pq[category].size() >= arr[idx]) {
                startTime = pq[category].peek().end;
                temp += startTime - reqStart; // 대기 시간 계산
                pq[category].poll(); // 상담원 교체
            }

            // 3. 상담 시작 및 종료 시간 기준 Participant 추가
            Participant newP = new Participant(startTime, startTime + duration, category);
            pq[category].add(newP);
            }

        // 최솟값 갱신
        answer = Math.min(answer, temp);
    }

class Participant implements Comparable<Participant>{
    int start, end, category;
    public Participant (int start, int end, int category) {
        this.start = start;
        this.end = end;
        this.category = category;
    }
    
    @Override
    public int compareTo(Participant p) {
        if (p.end == this.end) {
            return Integer.compare(this.start, p.start);
        } else {
            return Integer.compare(this.end, p.end);
        }
    }
}
}