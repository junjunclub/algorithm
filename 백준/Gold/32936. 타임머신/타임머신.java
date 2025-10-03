import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static int N, M, A, B, C;
    static int INF = 1_000_000_007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
        }

        int dd = INF, da = INF, db = INF, dba = INF;

        int[] dist;

        dist = bfs(1);
        if (dist[N] > 0) dd = dist[N] - 1;
        if (dist[A] > 0) da = dist[A] - 1;

        dist = bfs(B);
        if (dist[N] > 0) db = dist[N] - 1;
        if (dist[A] > 0) dba = dist[A] - 1;

        if (da < INF && db < INF) {
            dd = Math.min(dd, da + db - C);
        }

        if (da < INF && db < INF && dba < INF && dba < C) {
            System.out.println("-inf");
        } else if (dd < INF) {
            System.out.println(dd);
        } else {
            System.out.println("x");
        }
    }

    static int[] bfs(int start) {
        int[] dist = new int[N + 1];
        Queue<Integer> q = new ArrayDeque<>();
        dist[start] = 1;
        q.add(start);

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int nxt : graph[cur]) {
                if (dist[nxt] != 0) continue;
                dist[nxt] = dist[cur] + 1;
                q.add(nxt);
            }
        }
        return dist;
    }
}
