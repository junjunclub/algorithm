import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] board;
    public static void main(String[] args) throws Exception{
        init();
        solve();
    }

    private static void solve() {
        long[][] dp = new long[N][N];

        dp[0][0] = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int jump = board[i][j];

                if (jump == 0) break;
                if (i + jump < N) dp[i+jump][j] += dp[i][j];
                if (j + jump < N) dp[i][j+jump] += dp[i][j];
            }
        }
        System.out.println(dp[N-1][N-1]);
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
