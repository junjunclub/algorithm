import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int V, E;
    static Queue<Node1197> pq = new PriorityQueue<>();
    static List<Node1197>[] list;
    static boolean[] visited;
    static int answer = 0;
    public static void main(String[] args) throws Exception{
            init();
            solve();
        }

    private static void solve() {
        prim(1);
        System.out.println(answer);
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        list = new ArrayList[V+1];
        visited = new boolean[V+1];

        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node1197(b, c));
            list[b].add(new Node1197(a, c));
        }
    }

    private static void prim(int start) {
        pq.add(new Node1197(start, 0));

        while(!pq.isEmpty()) {
            Node1197 now = pq.poll();

            int node = now.to;
            int v = now.v;

            if (visited[node]) continue;

            visited[node] = true;
            answer += v;

            for (Node1197 next : list[node]) {
                if (!visited[next.to]) {
                    pq.add(next);
                }
            }
        }
    }
}

class Node1197 implements Comparable<Node1197>{
    int to, v;
    public Node1197 (int to, int v) {
        this.to = to;
        this.v = v;
    }
    @Override
    public int compareTo(Node1197 n) {
        return Integer.compare(this.v, n.v);
    }
}