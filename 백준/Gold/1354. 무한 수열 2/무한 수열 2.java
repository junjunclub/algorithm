import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static long N;
    static int P, Q, X, Y;
    static Map<Long, Long> dp;
    public static void main(String[] args) throws Exception{
        init();
        solve();
    }

    private static void solve() {
        dp = new HashMap<>();

        System.out.println(recur(N, P, Q, X, Y));
    }

    private static long recur(long n, int p, int q, int x, int y) {
        if (n <= 0) return 1;

        if (dp.containsKey(n)) return dp.get(n);

        dp.put(n, recur(n / p - x, p, q, x, y) + recur(n / q - y, p, q, x, y));
        return dp.get(n);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
    }
}
