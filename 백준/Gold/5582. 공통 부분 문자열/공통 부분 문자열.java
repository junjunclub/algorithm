import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static String str1, str2;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
            init();
            solve();
        }

    private static void solve() {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        int answer = 0;
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    answer = Math.max(dp[i][j], answer);
                }
            }
        }
        System.out.println(answer);
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str1 = br.readLine();
        str2 = br.readLine();
    }
}
