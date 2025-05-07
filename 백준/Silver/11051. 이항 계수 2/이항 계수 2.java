import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[][] dp;
    static int MOD = 10007;
    public static void main(String[] args) throws Exception{
        init();
        solve();
    }

    private static void solve() {
        System.out.println(Comb(N, K));
    }

    private static int Comb(int n, int k) {
        if (k == 0 || n == k) {
            return dp[n][k] = 1;
        }

        if (dp[n][k] > 0) {
            return dp[n][k];
        }

        return dp[n][k] = (Comb(n-1, k-1) + Comb(n-1, k)) % MOD;
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new int[N+1][K+1];
    }
}
