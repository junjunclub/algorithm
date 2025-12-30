import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Pair implements Comparable<Pair>{
        int n, cnt;

        public Pair (int n, int cnt) {
            this.n = n;
            this.cnt = cnt;
        }

        public void decrease () {
            this.cnt--;
        }

        @Override
        public int compareTo (Pair p) {
            return Integer.compare(p.cnt, this.cnt);
        }
    }

    static int N, M;
    static StringBuilder sb = new StringBuilder();
    static Queue<Pair> pq;

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    private static void solve() {
        int lastV = -1;

        for (int i = 0; i < N; i++) {
            Pair firstPair = pq.poll();
            if (firstPair == null) {
                System.out.println(-1);
                return;
            }

            //
            if (firstPair.n == lastV) {
                Pair secondPair = pq.poll();

                if (secondPair == null) {
                    System.out.println(-1);
                    return;
                }

                lastV = secondPair.n;
                secondPair.decrease();
                sb.append(lastV).append(" ");

                if (secondPair.cnt > 0) {
                    pq.add(secondPair);
                }
                pq.add(firstPair);
            } else {
                lastV = firstPair.n;
                firstPair.decrease();
                sb.append(lastV).append(" ");

                if (firstPair.cnt > 0) {
                    pq.add(firstPair);
                }
            }
        }

        System.out.println(sb);
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= M; i++) {
            int n = Integer.parseInt(st.nextToken());
            pq.add(new Pair(i, n));
        }
    }
}