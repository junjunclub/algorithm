import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N, M;
    public static void main(String[] args) throws Exception{
            init();
            solve();
        }

    private static void solve() {
        int[][] dp = new int[N + 1][M + 1];

        for (int i = 1; i <= M; i++) dp[1][i] = 1;
        for (int i = 1; i <= N; i++) dp[i][i] = 1;

        for (int i = 2; i <= N; i++) {
            for (int j = i; j <= M; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
            }
        }
        System.out.println(dp[N][M]);
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
    }
}
