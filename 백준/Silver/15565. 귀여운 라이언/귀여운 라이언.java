import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] arr;
    public static void main(String[] args) throws Exception{
            init();
            solve();
        }

    private static void solve() {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if (arr[i] == 1) list.add(i);
        }

        if (list.size() < K) {
            System.out.println(-1);
        } else {
            int ans = Integer.MAX_VALUE;

            for (int i = 0; i <= list.size() - K; i++) {
                int start = list.get(i);
                int end = list.get(i + K - 1);

                ans = Math.min(ans, end - start + 1);
            }
            System.out.println(ans);
        }
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
