import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] list = new int[n+1];
        int[] dp = new int[k+1];

        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= n; i++) {
            for (int j = list[i]; j <= k; j++) {
                dp[j] += dp[j - list[i]];
            }
        }

        System.out.println(dp[k]);

    }
}
