import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] arr, dp;
    public static void main(String[] args) throws Exception{
        init();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String input = br.readLine();


            StringTokenizer st = new StringTokenizer(input);
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) break;

            arr = new int[N][M];
            dp = new int[N][M];

            int res = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if (arr[i][j] == 1) {
                        res = 1;
                    }
                }
            }

            for (int i = 0; i < M; i++) {
                if (arr[0][i] == 1) {
                    dp[0][i] = 1;
                }
            }

            for (int i = 0; i < N; i++) {
                if (arr[i][0] == 1) {
                    dp[i][0] = 1;
                }
            }

            for (int i = 1; i < N; i++) {
                for (int j = 1; j < M; j++) {
                    if (arr[i][j] == 1) {

                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i- 1][j - 1]) + 1;
                        res = Math.max(dp[i][j], res);
                    }
                }
            }
            sb.append(res).append("\n");
        }

        System.out.println(sb);
    }
}
