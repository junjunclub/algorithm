import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static long n, p, q;
    static Map<Long, Long> map;
    public static void main(String[] args) throws Exception{
        init();
        solve();
    }

    private static void solve() {
        map.put(0L, 1L);
        dfs(n);
        System.out.println(map.get(n));
    }

    private static long dfs(long num) {
        if (map.containsKey(num)) {
            return map.get(num);
        }

        long num1 = dfs((long) Math.floor(num/p));
        long num2 = dfs((long) Math.floor(num/q));
        map.put(num, num1+num2);
        return num1+num2;
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Long.parseLong(st.nextToken());
        p = Long.parseLong(st.nextToken());
        q = Long.parseLong(st.nextToken());
        map = new HashMap<>();
    }
}
