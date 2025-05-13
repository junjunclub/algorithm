import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, L, R, X, res;
    static int[] problems;
    public static void main(String[] args) throws Exception{
        init();
        solve();

        System.out.println(res);
    }

    private static void solve() {
        res = 0;

        if (N == 1) {
            return;
        }
        backTracking(0, 0, 0, Integer.MAX_VALUE, 0);
    }

    private static void backTracking(int level, int idx, int sum, int minV, int maxV) {
        if (level > N) {
            return;
        }

        if (level >= 2 && sum >= L && sum <= R) {
            if (maxV - minV >= X) {
                res++;
            }
        }

        for (int i = idx; i < N; i++) {
            backTracking(level + 1, i + 1, sum + problems[i], Math.min(minV, problems[i]), Math.max(maxV, problems[i]));
        }
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        problems = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            problems[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(problems);
    }
}
