import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Stack;

public class Main {
    static String str1, str2;
    static int[][] dp;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        init();
        solve();
    }

    private static void solve() {
        int len1 = str1.length();
        int len2 = str2.length();
        dp = new int[len1+1][len2+1];

        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i+1][j+1] = dp[i][j] + 1;
                } else {
                    dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }

        lcsToString(str1, len1, len2);

        System.out.println(dp[len1][len2]);
        System.out.println(sb);
    }

    private static void lcsToString(String str, int len1, int len2) {
        Stack<Character> stack = new Stack<>();

        while (len1 != 0 && len2 != 0) {
            if (len1 == 0 || len2 == 0) break;

            if (dp[len1][len2] == dp[len1 - 1][len2]) {
                len1--;
            } else if (dp[len1][len2] == dp[len1][len2 - 1]) {
                len2--;
            } else {
                len1--;
                len2--;
                stack.add(str.charAt(len1));
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str1 = br.readLine();
        str2 = br.readLine();
    }
}
