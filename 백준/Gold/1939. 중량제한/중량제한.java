import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /**
    다시 풀기
    */
    static int n, m, start, end;
    static ArrayList<Integer>[] list;
    static Map<Integer, Map<Integer, Integer>> weights = new HashMap<>();
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];

        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (weights.containsKey(a) && weights.get(a).containsKey(b)) {
                weights.get(a).put(b, Math.max(weights.get(a).get(b), c));
            } else {
                list[a].add(b);
                list[b].add(a);

                if (!weights.containsKey(a)) {
                    weights.put(a, new HashMap<>());
                }

                if (!weights.containsKey(b)) {
                    weights.put(b, new HashMap<>());
                }

                weights.get(a).put(b, c);
                weights.get(b).put(a, c);
            }
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
    }

    private static void solve() {
        int answer = dijk(start, end, n);

        System.out.println(answer);
    }

    private static int dijk(int start, int end, int n) {
        PriorityQueue<Node1939> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n + 1];

        pq.offer(new Node1939(start, Integer.MAX_VALUE));

        while (!pq.isEmpty()) {
            Node1939 node = pq.poll();

            if (node.to == end) {
                return node.weight;
            }

            if (visited[node.to]) continue;

            visited[node.to] = true;

            for (int next : list[node.to]) {
                if (!visited[next]) {
                    pq.offer(new Node1939(next, Math.min(node.weight, weights.get(node.to).get(next))));
                }
            }
        }
        return 0;
    }
}

class Node1939 implements Comparable<Node1939>{
    int to;
    int weight;
    public Node1939 (int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
    @Override
    public int compareTo (Node1939 n) {
        return Long.compare(n.weight, this.weight);
    }
}
