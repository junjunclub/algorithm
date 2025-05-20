import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, E, v1, v2, answer1, answer2;
    static List<Node1504>[] list;
    public static void main(String[] args) throws Exception{
            init();
            solve();
        }

    private static void solve() {
        answer1 = 0;
        answer2 = 0;

        int path1 = dijk(1, v1);
        int path2 = dijk(v1, v2);
        int path3 = dijk(v2, N);

        int path4 = dijk(1, v2);
        int path5 = dijk(v2, v1);
        int path6 = dijk(v1, N);

        if (path1 == Integer.MAX_VALUE || path2 == Integer.MAX_VALUE || path3 == Integer.MAX_VALUE) {
            answer1 = Integer.MAX_VALUE;
        } else {
            answer1 = path1 + path2 + path3;
        }

        if (path4 == Integer.MAX_VALUE || path5 == Integer.MAX_VALUE || path6 == Integer.MAX_VALUE) {
            answer2 = Integer.MAX_VALUE;
        } else {
            answer2 = path4 + path5 + path6;
        }

        if (answer1 == Integer.MAX_VALUE && answer2 == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(answer1, answer2));
        }
    }

    private static int dijk(int start, int end) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[start] = 0;
        Queue<Node1504> pq = new PriorityQueue<>();
        pq.offer(new Node1504(start, 0));
        boolean[] visited = new boolean[N + 1];

        while (!pq.isEmpty()) {
            Node1504 now = pq.poll();
            int loc = now.to;

            if (visited[loc]) continue;

            visited[loc] = true;

            for (Node1504 next : list[loc]) {
                if (!visited[next.to] && dist[loc] + next.weight < dist[next.to]) {
                    dist[next.to] = dist[loc] + next.weight;
                    pq.offer(new Node1504(next.to, dist[next.to]));
                }
            }
        }
        return dist[end];
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[s].add(new Node1504(e, w));
            list[e].add(new Node1504(s, w));
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());
    }
}

class Node1504 implements Comparable<Node1504> {
    int to, weight;
    public Node1504 (int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
    @Override
    public int compareTo (Node1504 n) {
        return Integer.compare(this.weight, n.weight);
    }
}