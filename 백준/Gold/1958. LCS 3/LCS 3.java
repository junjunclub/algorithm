import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static String str1, str2, str3;
    public static void main(String[] args) throws Exception{
            init();
            solve();
        }

    private static void solve() {
        int[][][] dp = new int[str1.length() + 1][str2.length() + 1][str3.length() + 1];

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                for (int k = 1; k <= str3.length(); k++) {
                    if (str1.charAt(i - 1) == str2.charAt(j - 1) && str2.charAt(j - 1) == str3.charAt(k - 1)) {
                        dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
                    } else {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], Math.max(dp[i][j - 1][k], dp[i][j][k - 1]));
                    }
                }
            }
        }
        System.out.println(dp[str1.length()][str2.length()][str3.length()]);
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str1 = br.readLine();
        str2 = br.readLine();
        str3 = br.readLine();
    }
}
