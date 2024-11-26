import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static int n, m;
    static Node[] graph;
    static int[] dist;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new Node[n];

        dist = new int[10001];

        for (int i = 0; i < dist.length; i++) {
            dist[i] = i;
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[i] = new Node(s, e, w);
        }

        dijk(0);
        System.out.println(dist[m]);
    }

    private static void dijk(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0, 0));

        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int nowPos = cur.end;

            for (Node n : graph) {
                if (n.start >= nowPos) {
                    if (n.end > m) {
                        continue;
                    }
                    if (dist[n.end] > dist[nowPos] + n.weight + (n.start - nowPos)) {
                        dist[n.end] = dist[nowPos] + n.weight + (n.start - nowPos);
                        pq.offer(new Node(nowPos, n.end, dist[n.end]));
                    }
                }
            }
            dist[m] = Math.min(dist[nowPos] + m - nowPos, dist[m]);
        }
    }
}
class Node implements Comparable<Node> {
    int start;
    int end;
    int weight;

    public Node(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
    @Override
    public int compareTo(Node n) {
        return this.weight - n.weight;
    }
}
