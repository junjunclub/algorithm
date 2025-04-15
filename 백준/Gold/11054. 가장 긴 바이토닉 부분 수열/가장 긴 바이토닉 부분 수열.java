import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] dp1, dp2;
    static int[] list;
    public static void main(String[] args) throws Exception{
        init();
        solve();
    }

    private static void solve() {
        for (int i = 0; i < N; i++) {
            dp1[i] = 1;

            for (int j = 0; j < i; j++) {
                if (list[j] < list[i]) {
                    dp1[i] = Math.max(dp1[i], dp1[j] + 1);
                }
            }
        }

        for (int i = N-1; i >= 0; i--) {
            dp2[i] = 1;

            for (int j = N-1; j > i; j--) {
                if (list[j] < list[i]) {
                    dp2[i] = Math.max(dp2[i], dp2[j] + 1);
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer = Math.max(dp1[i] + dp2[i] - 1, answer);
        }

        System.out.println(answer);
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        list = new int[N];
        dp1 = new int[N];
        dp2 = new int[N];

        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

    }
}
