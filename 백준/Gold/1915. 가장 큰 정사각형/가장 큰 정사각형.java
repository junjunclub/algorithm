import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, answer;
    static int[][] arr, dp;
    public static void main(String[] args) throws Exception{
            init();
            solve();
        }

    private static void solve() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dp[i][j] = arr[i][j];
                if (i != 0 && j != 0 && dp[i][j] != 0) {
                    int minV = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1]));
                    dp[i][j] = minV + 1;
                    answer = Math.max(dp[i][j], answer);
                }
            }
        }
        System.out.println(answer * answer);
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        dp = new int[N + 1][M + 1];
        answer = 0;

        for (int i = 0; i < N; i++) {
            char[] str = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str[j] - '0';
                if (arr[i][j] == 1) {
                    answer = 1;
                }
            }
        }
    }
}
