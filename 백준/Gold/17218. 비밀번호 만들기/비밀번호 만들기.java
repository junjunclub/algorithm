import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String str1, str2;
    public static void main(String[] args) throws Exception{
        init();
        solve();
    }

    private static void solve() {
        int length1 = str1.length();
        int length2 = str2.length();

        int[][] dp = new int[length1 + 1][length2 + 1];

        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        int r = length1;
        int c = length2;

        int cnt = dp[length1][length2];

        StringBuilder sb = new StringBuilder();

        while (cnt > 0) {
            if (cnt == dp[r - 1][c]) {
                r--;
            } else if (cnt == dp[r][c - 1]) {
                c--;
            } else {
                r--;
                c--;
                cnt--;
                sb.append(str1.charAt(r));
            }
        }

        System.out.println(sb.reverse());
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str1 = br.readLine();
        str2 = br.readLine();
    }
}
