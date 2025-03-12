import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int t,n;
    static PriorityQueue<Long> pq;
    static int answer;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        init();

        /**
         * 1. 우선순위 큐에서 값을 빼주고 다시 넣어준다.
         * 2. 우선순위가 모두 빌 때 까지 반복한다.
         */

        System.out.println(sb);
    }

    private static void solve() {
        long result = 0;

        while (pq.size() > 1) {
            long t1 = pq.poll();
            long t2 = pq.poll();
            long temp = t1 + t2;
            result += temp;
            pq.add(temp);
        }
        sb.append(result).append("\n");
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            pq = new PriorityQueue<>();
            answer = 0;
            n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                long num = Long.parseLong(st.nextToken());
                pq.add(num);
            }
            solve();
        }
    }
}