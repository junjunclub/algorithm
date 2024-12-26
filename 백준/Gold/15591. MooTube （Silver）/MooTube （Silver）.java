import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static private StringTokenizer st;
    static private ArrayList<ArrayList<Node>> list = new ArrayList<ArrayList<Node>>();
    static private int N;
    static private class Node {
        int v, cost;
        public Node (int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<Node>());
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            list.get(p).add(new Node(q, r));
            list.get(q).add(new Node(p, r));
        }
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            sb.append(validate(k ,v)).append("\n");
        }
        System.out.println(sb);
    }

    private static int validate(int k, int v) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(v, Integer.MAX_VALUE));
        boolean[] visited = new boolean[N+1];
        visited[v] = true;
        int minV, temp = 0;
        while (!q.isEmpty()) {
            Node node = q.poll();
            ArrayList<Node> videos = list.get(node.v);

            for (int i = 0; i < videos.size(); i++) {
                if (visited[videos.get(i).v]) continue;
                minV = Math.min(videos.get(i).cost, node.cost);

                if (minV >= k) {
                    temp++;
                    visited[videos.get(i).v] = true;
                    q.add(new Node(videos.get(i).v, minV));
                }
            }
        }
        return temp;
    }
}
