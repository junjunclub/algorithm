import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class Main {
    static List<Star> stars;
    static List<Edge>[] graph;
    static boolean[] visited;
    static double answer = 0;
    static int N;
    public static void main(String[] args) throws Exception{
        init();
        solve();
    }

    private static void solve() {
        graph = new ArrayList[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                Star s1 = stars.get(i);
                Star s2 = stars.get(j);
                double dist = Math.sqrt(Math.pow(s1.x - s2.x, 2) + Math.pow(s1.y - s2.y, 2));
                graph[i].add(new Edge(j, dist));
                graph[j].add(new Edge(i, dist));
            }
        }

        prim(0);

        System.out.println(String.format("%.2f",answer));
    }

    private static void prim(int start) {
        Queue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            if (visited[now.to]) continue;

            visited[now.to] = true;
            answer += now.weight;

            for (Edge e : graph[now.to]) {
                if (!visited[e.to]) {
                    pq.add(e);
                }
            }
        }

    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        stars = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());

            stars.add(new Star(x, y, i));
        }
    }
}

class Star {
    double x, y;
    int idx;

    public Star(double x, double y, int idx) {
        this.x = x;
        this.y = y;
        this.idx = idx;
    }
}

class Edge implements Comparable<Edge> {
    int to;
    double weight;

    public Edge(int to, double weight) {
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return Double.compare(this.weight, o.weight);
    }
}