import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static int[][] list;
    static boolean[] visited;
    static int s, e, n;
    static int answer = 10001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new int[n+1][n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a][b] = 1;
            list[b][a] = 1;
        }

        int answer = dijk(s, e, n, list);

        System.out.println(answer);
    }

    private static int dijk(int start, int end, int n, int[][] list) {
        int[] dist = new int[n+1];
        boolean[] visited = new boolean[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[start] = 0;
        visited[start] = true;

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start, 0));

        while (!q.isEmpty()) {
            Node node = q.poll();

            int now = node.start;
            int cost = node.cost;

            if (now == end) {
                break;
            }

            for (int next = 1; next <= n; next++) {
                if (list[now][next] ==1 && !visited[next]) {
                    dist[next] = cost + 1;
                    visited[next] = true;

                    q.add(new Node(next, cost+1));
                }
            }
        }
        if (dist[end] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dist[end];
        }
    }
}

class Node implements Comparable<Node> {
    int start;
    int cost;

    public Node (int start, int cost) {
        this.start = start;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node node) {
        return this.cost-node.cost;
    }
}