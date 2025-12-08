import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, G, K, maxDay, minDay;
    static int[] S, L, O;
    public static void main(String[] args) throws Exception{
            init();
            solve();
        }

    private static void solve() {
        int res = 0;

        while (minDay <= maxDay) {
            int mid = minDay + (maxDay - minDay) / 2;

            if (check(mid)) {
                res = mid;
                minDay = mid + 1;
            } else {
                maxDay = mid - 1;
            }
        }

        System.out.println(res);
    }

    private static boolean check(int mid) {
        PriorityQueue<Long> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long v = 0;
        int cnt = K;
        for (int i = 0; i < N; i++) {
            long cost = (long) S[i] * Math.max(1, mid - L[i]);
            v += cost;

            if (O[i] == 1) {
                pq.add(cost);
            }

            if (v > G) {
                if (cnt-- <= 0 || pq.isEmpty()) return false;
                v -= pq.poll();
            }
        }

        while (cnt-- > 0 && !pq.isEmpty()) {
            v -= pq.poll();
        }

        return v <= G;
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        S = new int[N];
        L = new int[N];
        O = new int[N];

        maxDay = Integer.MAX_VALUE;
        minDay = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            S[i] = Integer.parseInt(st.nextToken());
            L[i] = Integer.parseInt(st.nextToken());
            O[i] = Integer.parseInt(st.nextToken());
        }

    }
}
