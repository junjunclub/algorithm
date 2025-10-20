import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int[][] arr, dp;
    public static void main(String[] args) throws Exception{
        init();
        solve();
    }

    private static void solve() {
        for (int i = 0; i <= M; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }

        dp[1][1] = 0;

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k < j; k++) {
                    if (arr[j - k][j] == 0 || dp[i - 1][j - k] == Integer.MIN_VALUE) continue;
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k] + arr[j - k][j]);
                }
            }
        }

        int ans = 0;

        for (int i = 0; i <= M; i++) {
            ans = Math.max(ans, dp[i][N]);
        }

        System.out.println(ans);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][N + 1];
        dp = new int[M + 1][N + 1];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if (s < e) {
                arr[s][e] = Math.max(arr[s][e], v);
            }
        }
    }
}
