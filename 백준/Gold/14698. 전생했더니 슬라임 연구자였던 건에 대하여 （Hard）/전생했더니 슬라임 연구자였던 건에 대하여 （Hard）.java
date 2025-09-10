import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int mod = 1_000_000_007;
    static int T, N;
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        init();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            Queue<Long> pq = new PriorityQueue<>();
            long v = 1;
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                pq.add(Long.parseLong(st.nextToken()));
            }

            while (pq.size() >= 2) {
                long num1 = pq.poll();
                long num2 = pq.poll();
                
                long addNum = (num1 * num2);
                long newNum = (num1 * num2) % mod;
                pq.add(addNum);
                v = (v * newNum) % mod;
            }

            sb.append(v).append("\n");
        }
        System.out.println(sb);
    }
}
