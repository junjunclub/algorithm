import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node2325 implements Comparable<Node2325>{
        int end, weight;

        public Node2325 (int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo (Node2325 n) {
            if (n.weight != this.weight) {
                return Integer.compare(this.weight, n.weight);
            }
            return Integer.compare(this.end, n.end);
        }
    }

    static int N, M, answer;
    static final int INF = Integer.MAX_VALUE;
    static List<Node2325>[] list;
    static int[] pathList;

    public static void main(String[] args) throws Exception{
            init();
            solve();
        }

    private static void solve() {
        dijk(1);
        
        int start = N;

        while (start != 0) {
            dijk(start, pathList[start]);
            start = pathList[start];
        }

        System.out.println(answer);
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new List[N + 1];
        pathList = new int[N + 1];
        answer = 0;

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[s].add(new Node2325(e, w));
            list[e].add(new Node2325(s, w));
        }
    }

    private static void dijk(int s, int e) {
        Queue<Node2325> q = new PriorityQueue<>();
        int[] dist = new int[N + 1];

        Arrays.fill(dist, INF);

        dist[1] = 0;
        q.add(new Node2325(1, 0));

        while (!q.isEmpty()) {
            Node2325 cur = q.poll();

            if (cur.weight > dist[cur.end]) continue;

            for (Node2325 next : list[cur.end]) {
                if ((cur.end == s && next.end == e) || (cur.end == e && next.end == s)) {
                    continue;
                }

                if (dist[cur.end] + next.weight < dist[next.end]) {
                    dist[next.end] = dist[cur.end] + next.weight;
                    q.add(new Node2325(next.end, dist[cur.end] + next.weight));
                }
            }
        }
        answer = Math.max(answer, dist[N]);
    }

    private static void dijk(int start) {
        int[] dist = new int[N + 1];

        Arrays.fill(dist, INF);

        dist[start] = 0;

        Queue<Node2325> pq = new PriorityQueue<>();
        pq.add(new Node2325(1, 0));

        while (!pq.isEmpty()) {
            Node2325 now = pq.poll();

            for (Node2325 next : list[now.end]) {
                int nextPoint = next.end;
                int w = next.weight;

                if (dist[now.end] + w < dist[nextPoint]) {
                    dist[nextPoint] = dist[now.end] + w;
                    pq.add(new Node2325(nextPoint, dist[now.end] + w));
                    pathList[nextPoint] = now.end;
                }
            }
        }
    }
}
