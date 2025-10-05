import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static final int MOD = 1_000_000_007;
    static int N;
    static char[] arr;

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    private static void solve() {
        long w = 0;
        long wh = 0;
        long whe = 0;
        long whee = 0;

        for (int i = 0; i < N; i++) {
            char c = arr[i];
            if (c == 'W') {
                w = (w + 1) % MOD;
            } else if (c == 'H') {
                wh = (wh + w) % MOD;
            } else if (c == 'E') {
                whee = (whee * 2 % MOD + whe) % MOD;
                whe = (whe + wh) % MOD;
            }
        }

        System.out.println(whee);
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = br.readLine().toCharArray();
    }
}
