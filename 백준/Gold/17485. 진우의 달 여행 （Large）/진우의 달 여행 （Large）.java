import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] board;
    static int[][][] dp;
    public static void main(String[] args) throws Exception{
        init();
        solve();
        /**
         * 0은 오른쪽에서 내려오는 방향
         * 1은 바로 위에서 내려오는 방향
         * 2는 왼쪽에서 내려오는 방향
         */
    }

    private static void solve() {
        // 처음 세팅
        for (int i = 0; i < M; i++) {
            dp[0][i][0] = board[0][i];
            dp[0][i][1] = board[0][i];
            dp[0][i][2] = board[0][i];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (j == 0) {
                    dp[i][j][0] = Math.min(dp[i-1][j+1][1], dp[i-1][j+1][2]) + board[i][j];
                    dp[i][j][1] = dp[i-1][j][0] + board[i][j];
                } else if (j == M - 1) {
                    dp[i][j][1] = dp[i-1][j][2] + board[i][j];
                    dp[i][j][2] = Math.min(dp[i-1][j-1][0], dp[i-1][j-1][1]) + board[i][j];
                } else {
                    dp[i][j][0] = Math.min(dp[i-1][j+1][1], dp[i-1][j+1][2]) + board[i][j];
                    dp[i][j][1] = Math.min(dp[i-1][j][0], dp[i-1][j][2]) + board[i][j];
                    dp[i][j][2] = Math.min(dp[i-1][j-1][0], dp[i-1][j-1][1]) + board[i][j];
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 3; j++) {
                answer = Math.min(answer, dp[N-1][i][j]);
            }
        }
        System.out.println(answer);
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        dp = new int[N+1][M+1][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }
    }
}
