import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static String str;
    static int N, length;
    static int[] dp;
    static Set<String> set;
    public static void main(String[] args) throws Exception{
            init();
            solve();
        }

    private static void solve() {
        for (int i = length - 1; i >= 0; i--) {
            String temp1 = str.substring(i);
            for (int j = i + 1; j < length; j++) {
                String temp2 = str.substring(i, j);
                if (dp[j] == 1 && set.contains(temp2)) {
                    dp[i] = 1;
                }
            }

            if (set.contains(temp1)) {
                dp[i] = 1;
            }
        }
        System.out.println(dp[0]);
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        length = str.length();
        dp = new int[length + 1];
        N = Integer.parseInt(br.readLine());
        set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            set.add(input);
        }
    }
}
