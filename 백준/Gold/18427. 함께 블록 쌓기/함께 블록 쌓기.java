import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M, H;
    static int[][] dp;
    static List<Integer>[] list;
    public static void main(String[] args) throws Exception{
        init();
        solve();
    }

    private static void solve() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= H; j++) {
                for (int n : list[i]) {
                    if (j == n) dp[i][j]++;
                    if (j > n) {
                        dp[i][j] += dp[i - 1][j - n];
                    }
                }
                dp[i][j] += dp[i - 1][j];
                dp[i][j] %= 10007;
            }
        }

        System.out.println(dp[N][H]);
    }

    private static void init() throws IOException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        list = new List[N + 1];

        for (int i = 1; i <= N; i++){
            list[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                list[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        dp = new int[N + 1][H + 1];
    }
}
