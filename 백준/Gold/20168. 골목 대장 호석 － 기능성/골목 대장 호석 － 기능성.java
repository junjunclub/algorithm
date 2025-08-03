import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node>{
        int end, weight;
        public Node (int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
        @Override
        public int compareTo (Node n) {
            if (n.weight != this.weight) {
                return Integer.compare(this.weight, n.weight);
            }
            return Integer.compare(this.end, n.end);
        }
    }

    static int N, M, S, E, C, ans;
    static List<Node>[] list;
    public static void main(String[] args) throws Exception{
            init();
            solve();
        }

    private static void solve() {
        binarySearch(S, E);
        System.out.println(ans);
    }

    private static void binarySearch(int s, int e) {
        int l = 1;
        int r = 1001;
        int mid;
        while (l <= r) {
            mid = (l + r) / 2;

            if (dijk(mid)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
    }

    private static boolean dijk(int mid) {
        Queue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;

        pq.offer(new Node(S, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (dist[cur.end] < cur.weight) continue;

            for (Node next : list[cur.end]) {
                if (next.weight > mid) continue;

                if (dist[next.end] > dist[cur.end] + next.weight) {
                    dist[next.end] = dist[cur.end] + next.weight;
                    pq.offer(new Node(next.end, dist[next.end]));
                }
            }
        }

        return dist[E] <= C;
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        ans = -1;

        list = new List[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            Node node1 = new Node(e, w);
            Node node2 = new Node(s, w);
            list[s].add(node1);
            list[e].add(node2);
        }
    }
}
