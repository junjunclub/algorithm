import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] list, dp;
    public static void main(String[] args) throws Exception{
        init();
        solve();
    }

    private static void solve() {
        for (int i = 0; i < N; i++) {
            for (int j = list[i]; j <= K; j++) {
                dp[j] = Math.min(dp[j], dp[j - list[i]]+1);
            }
        }

        if (dp[K] == Integer.MAX_VALUE-1) {
            System.out.println(-1);
        } else {
            System.out.println(dp[K]);
        }
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        list = new int[N+1];
        dp = new int[K+1];
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= K; i++) {
            dp[i] = Integer.MAX_VALUE - 1;
        }
    }
}
