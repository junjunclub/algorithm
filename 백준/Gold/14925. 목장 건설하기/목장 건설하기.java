import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] board, dp;
    public static void main(String[] args) throws Exception{
            init();
            solve();
        }

    private static void solve() {
        int ans = 0;

        for (int i = 0; i < M; i++) {
            if (board[0][i] == 0) {
                dp[0][i] = 1;
                ans = 1;
            }
        }

        for (int i = 0; i < N; i++) {
            if (board[i][0] == 0) {
                dp[i][0] = 1;
                ans = 1;
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                if (board[i][j] == 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
                    ans = Math.max(ans, dp[i][j]);
               }
            }
        }

        System.out.println(ans);
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        dp = new int[N + 1][M + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
