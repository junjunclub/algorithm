import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T, W;
    static int[][] dp;
    public static void main(String[] args) throws Exception{
        init();
        solve();
    }

    private static void solve() {

    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        dp = new int[T+1][W+1];

        for (int i = 1; i <= T; i++) {
            int n = Integer.parseInt(br.readLine());

            for (int j = 0; j <= W; j++) {
                // 시작할 때
                if (j == 0) {
                    if (n == 1) {
                        dp[i][j] = dp[i-1][j] + 1;
                    } else {
                        dp[i][j] = dp[i-1][j];
                    }
                } else if (j % 2 == 1) {
                    // j가 홀수초 일 때 (2번 나무임)
                    if (n == 1) {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1] + 1);
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j] + 1, dp[i-1][j-1]);
                    }

                } else {
                    // j가 짝수초 일 때
                    if (n == 1) {
                        dp[i][j] = Math.max(dp[i-1][j] + 1, dp[i-1][j-1]);
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1] + 1);
                    }
                }
            }
        }
        int answer = 0;
        for (int i = 0; i <= W; i++) {
            answer = Math.max(dp[T][i], answer);
        }
        
        System.out.println(answer);
    }
}
