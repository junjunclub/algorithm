import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] m, c;
    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    private static void solve() {
        int[][] dp = new int[N + 1][10001];

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            int memory = m[i];
            int cost = c[i];

            for (int j = 0; j <= 10000; j++) {

                if (i == 0) {
                    if (j >= cost) dp[i][j] = memory;
                } else {
                    if (j >= cost) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - cost] + memory);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }

                if (dp[i][j] >= M) {
                    ans = Math.min(j, ans);
                }
            }
        }

        System.out.println(ans);
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        m = new int[N];
        c = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            m[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            c[i] = Integer.parseInt(st.nextToken());
        }
    }
}