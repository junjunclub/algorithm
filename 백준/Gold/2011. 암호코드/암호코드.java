import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static String str;
    static int N;
    static int[] dp;
    static int MOD = 1000000;
    public static void main(String[] args) throws Exception{
        init();
        solve();
        /**
         * dp[0], dp[1]을 1로 초기화
         * 그 다음부터, i-1에 해당하는 숫자가 1이면 더해주기 dp[i-1]+dp[i-2]
         * i-1이 2면, i가 0~6 사이여야 dp[i-1]+dp[i-2].
         * 그 이외의 경우면 dp[i-1]
         */
    }

    private static void solve() {
        if (str.charAt(0) == '0') {
            System.out.println(0);
            return;
        }

        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            int first = str.charAt(i-1) - '0';
            int second = str.charAt(i-2) - '0';
            int num = second*10 + first;

            if (first != 0) {
                dp[i] += dp[i-1];
                dp[i] %= MOD;
            }

            if (num >= 10 && num <= 26) {
                dp[i] += dp[i-2];
                dp[i] %= MOD;
            }
        }

        System.out.println(dp[N]);
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        N = str.length();
        dp = new int[N+1];
    }
}
