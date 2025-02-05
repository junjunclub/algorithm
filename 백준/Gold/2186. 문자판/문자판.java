import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m, k;
    static char[][] board;
    static String answer;
    static long result = 0;
    static int[][][] dp;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};
    public static void main(String[] args) throws Exception{
        init();
        solve();

        /**
         * 1. dfs 돌리기
         * 2.
         */
    }

    private static void solve() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == answer.charAt(0)) {
                    result += dfs(i, j, 0);
                }
            }
        }

        System.out.println(result);
    }

    private static int dfs(int r, int c, int depth) {
        if (dp[r][c][depth] != -1) {
            return dp[r][c][depth];
        }

        if (depth == answer.length() - 1) {
            return dp[r][c][depth] = 1;
        }

        dp[r][c][depth] = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= k; j++) {
                int newR = r + dr[i] * j;
                int newC = c + dc[i] * j;

                if (0 > newR || newR >= n || 0 > newC || newC >= m) continue;

                if (board[newR][newC] == answer.charAt(depth+1)) {
                    dp[r][c][depth] += dfs(newR, newC, depth + 1);
                }
            }
        }
        return dp[r][c][depth];
    }


    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        board = new char[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            board[i] = st.nextToken().toCharArray();
        }

        answer = br.readLine();
        dp = new int[n][m][answer.length()];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
    }
}