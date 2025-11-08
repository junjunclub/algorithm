import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int[] parents, candy, groupCandy, groupCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        candy = new int[N + 1];
        parents = new int[N + 1];
        groupCandy = new int[N + 1];
        groupCount = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            candy[i] = Integer.parseInt(st.nextToken());
            parents[i] = i;
            groupCount[i] = 1;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            union(n1, n2);
        }

        solve();
    }

    private static void solve() {
        for (int i = 1; i <= N; i++) {
            int root = find(i);
            groupCandy[root] += candy[i];
        }

        int[] dp = new int[K];
        for (int i = 1; i <= N; i++) {
            if (i == find(i)) {
                int w = groupCount[i];
                int v = groupCandy[i];

                for (int j = K - 1; j >= w; j--) {
                    dp[j] = Math.max(dp[j], dp[j - w] + v);
                }
            }
        }

        System.out.println(dp[K - 1]);
    }

    private static void union (int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa == pb) return;

        if (pa < pb) {
            parents[pb] = pa;
            groupCount[pa] += groupCount[pb];
        } else {
            parents[pa] = pb;
            groupCount[pb] += groupCount[pa];
        }
    }

    private static int find (int x) {
        if (parents[x] != x) {
            return parents[x] = find(parents[x]);
        }
        return parents[x];
    }
}