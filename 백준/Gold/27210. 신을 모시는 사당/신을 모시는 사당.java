import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, result;
    static int[][] dp;
    public static void main(String[] args) throws Exception{
        init();
        solve();
    }

    private static void solve() {
        System.out.println(result);
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1][2];
        result = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());
            int reverse = num-- % 2;

            dp[i][num] = dp[i-1][num] + 1;

            if (dp[i-1][reverse] > 0) {
                dp[i][reverse] = dp[i-1][reverse] - 1;
            }

            result = Math.max(result, dp[i][num]);
        }
    }
}
