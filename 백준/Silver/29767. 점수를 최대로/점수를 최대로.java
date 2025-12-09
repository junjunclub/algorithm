import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] arr;
    public static void main(String[] args) throws Exception{
            init();
            solve();
        }

    private static void solve() {
        long[] sum = new long[N];

        sum[0] = arr[0];

        for (int i = 1; i < N; i++) {
            sum[i] = arr[i] + sum[i - 1];
        }

        Arrays.sort(sum);

        long ans = 0;
        for (int i = 0; i < K; i++) {
            ans += sum[N - 1 - i];
        }

        System.out.println(ans);
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}
