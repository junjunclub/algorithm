import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, start, end;

    static class Node implements Comparable<Node>{
        int target, w;

        public Node (int target, int w) {
            this.target = target;
            this.w = w;
        }

        @Override
        public int compareTo (Node n) {
            return Integer.compare(this.w, n.w);
        }
    }

    static List<Node>[] graph;

    public static void main(String[] args) throws Exception{
            init();
            solve();
        }

    private static void solve() {
        dijk(start, end);
    }

    private static void dijk(int start, int end) {
        StringBuilder sb = new StringBuilder();
        Queue<Node> pq = new PriorityQueue<>();

        int[] dist = new int[N + 1];
        int[] parents = new int[N + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[start] = 0;

        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (dist[cur.target] < cur.w) continue;

            for (Node next : graph[cur.target]) {
                if (dist[next.target] <= next.w + dist[cur.target]) continue;

                pq.add(new Node(next.target, next.w + dist[cur.target]));
                parents[next.target] = cur.target;
                dist[next.target] = next.w + dist[cur.target];
            }
        }

        int goal = end;

        sb.append(dist[end]).append("\n");

        List<Integer> ans = new ArrayList<>();

        ans.add(goal);

        while (true) {
            ans.add(parents[goal]);
            goal = parents[goal];

            if (goal == start) break;
        }

        sb.append(ans.size()).append("\n");

        for (int i = ans.size() - 1; i >= 0; i--) {
            sb.append(ans.get(i)).append(" ");
        }
        
        System.out.println(sb);
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        graph = new List[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        M = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[s].add(new Node(e, w));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
    }
}
