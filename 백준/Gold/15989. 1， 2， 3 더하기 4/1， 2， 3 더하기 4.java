import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        /**
         *  4 : 1 1 1 1, 1 1 2, 1 3, 2 2 (4개)
         *  5 : 1 1 1 1 1, 1 1 1 2, 1 2 2, 1 1 3, 2 3 (5개)
         *  6 : 1 1 1 1 1 1, 1 1 1 1 2, 1 1 2 2, 1 2 3, 2 2 2, 3 3 (6개)
         *  7 : 1 1 1 1 1 1 1, 1 1 1 1 1 2, 1 1 1 2 2, 1 2 2 2, 1 1 1 1 3, 1 1 2 3, 1 3 3, 2 2 3 (8개)
         *  8 : 1 1 1 1 1 1 1 1, 1 1 1 1 1 1 2, 1 1 1 1 2 2, 1 1 2 2 2, 1 1 1 1 1 3, 1 1 3 3, 1 1 1 2 3, 1 2 2 3, 2 2 2 2, 2 3 3 (10개)
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[][] dp = new int[10001][4];
        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for (int i = 4; i < 10001; i++) {
            dp[i][1] = dp[i-1][1];
            dp[i][2] = dp[i-2][1] + dp[i-2][2];
            dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
        }

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            sb.append(dp[num][1] + dp[num][2] + dp[num][3]).append("\n");
        }

        System.out.println(sb);
    }
}
