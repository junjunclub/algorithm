import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] sumArr;
    public static void main(String[] args) throws Exception{
            init();
            solve();
        }

    private static void solve() {
        long ans = 0;
        Map<Integer, Long> map = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            if (sumArr[i] == K) ans++;

            ans += map.getOrDefault(sumArr[i] - K, 0L);
            map.put(sumArr[i], map.getOrDefault(sumArr[i], 0L) + 1);
        }

        System.out.println(ans);
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        sumArr = new int[N + 1];

        st = new StringTokenizer(br.readLine());

        int sum = 0;

        for (int i = 1; i <= N; i++) {
            sum += Integer.parseInt(st.nextToken());
            sumArr[i] = sum;
        }
    }
}
