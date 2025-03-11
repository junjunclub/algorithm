import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] arr;
    static int[][] dp;
    static int answer;
    public static void main(String[] args) throws Exception{
        init();
        solve();

        /**
         * 1. DP문제
         * 2. 3개 중 위에서 선택한 색을 제외하면서 최솟값을 갱신하면서 밑으로 내려감
         * 3. 처음이랑 마지막을 어떻게 해야하지???
         */

        System.out.println(answer);
    }

    private static void solve() {
        answer = Integer.MAX_VALUE;

        for (int fixColor = 0; fixColor < 3; fixColor++) {
            dp = new int[n][3];

            for (int i = 0; i < 3; i++) {
                if (i == fixColor) {
                    dp[0][i] = arr[0][i];
                } else {
                    dp[0][i] = 10000000;
                }
            }

            for (int i = 1; i < n; i++) {
                dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][0];
                dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + arr[i][1];
                dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i][2];
            }

            for (int i = 0; i < 3; i++) {
                if (fixColor != i) {
                    answer = Math.min(answer, dp[n-1][i]);
                }
            }
        }

    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
