import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node {
        int end;

        public Node (int end) {
            this.end = end;
        }
    }

    static int N;
    static List<Node>[] list;
    static int[] weights;
    static int[] nodeCnt;
    static Queue<Integer> q;
    public static void main(String[] args) throws Exception{
        init();
        solve();
    }

    private static void solve() {
        int[] dp = new int[N + 1];

        while (!q.isEmpty()) {
            int now = q.poll();

            for (Node n : list[now]) {
                int next = n.end;

                nodeCnt[next]--;

                dp[next] = Math.max(dp[next], dp[now] + weights[now]);

                if (nodeCnt[next] == 0) {
                    q.add(next);
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            ans = Math.max(ans, dp[i] + weights[i]);
        }
        System.out.println(ans);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        q = new LinkedList<>();

        weights = new int[N + 1];
        nodeCnt = new int[N + 1];
        list = new List[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            weights[i] = weight;
            int T = Integer.parseInt(st.nextToken());
            nodeCnt[i] = T;

            if (T == 0) {
                q.add(i);
            }

            for (int j = 0; j < T; j++) {
                int e = Integer.parseInt(st.nextToken());

                list[e].add(new Node(i));
            }
        }
    }
}
