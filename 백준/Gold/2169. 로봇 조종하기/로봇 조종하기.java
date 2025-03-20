import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] board;
    public static void main(String[] args) throws Exception{
        init();
        solve();

        /**
         * 1. 왼쪽으로 가는 경우 모두 판단
         * 2. 오른쪽으로 가는 경우 모두 판단
         * 3. DP 배열 갱신
         * 4. 이걸 어캐 생각함?
         */
    }

    private static void solve() {
        // dp 배열 초기 세팅
        int[][] dp = new int[N][M];
        dp[0][0] = board[0][0];
        for (int i = 1; i < M; i++) {
            dp[0][i] = dp[0][i-1] + board[0][i];
        }

        // 2번째 행부터
        for (int i = 1; i < N; i++) {
            int[] left = new int[M];
            int[] right = new int[M];

            left[0] = dp[i-1][0] + board[i][0];
            right[M-1] = dp[i-1][M-1] + board[i][M-1];

            // left 갱신
            for (int j = 1; j < M; j++) {
                left[j] = Math.max(dp[i-1][j], left[j-1]) + board[i][j];
            }

            // right 갱신
            for (int j = M-2; j >= 0; j--) {
                right[j] = Math.max(dp[i-1][j], right[j+1]) + board[i][j];
            }

            for (int j = 0; j < M; j++) {
                dp[i][j] = Math.max(left[j], right[j]);
            }
        }

        System.out.println(dp[N-1][M-1]);
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
