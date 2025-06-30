import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, Q;
    static int[] arr, sumArr;
    public static void main(String[] args) throws Exception{
            init();
            solve();
        }

    private static void solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        sumArr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            sumArr[i] = sumArr[i - 1] + arr[i - 1];
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            sb.append(sumArr[end] - sumArr[start - 1]).append("\n");
        }
        System.out.println(sb);
    }

    private static void init() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
    }
}
