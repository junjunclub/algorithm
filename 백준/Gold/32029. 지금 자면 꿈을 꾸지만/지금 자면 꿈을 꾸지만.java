import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, A, B;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    private static void solve() {
        int maxCnt = 0;

        // x = 자는 시간
        for (int x = 0; x < A; x++) {
            for (int start = 1; start <= N; start++) {
                maxCnt = Math.max(maxCnt, calculate(start, x));
            }
        }

        System.out.println(maxCnt);
    }

    private static int calculate(int start, int x) {
        int temp = 0;
        int now = 0;

        // 잠자기 전 과제
        for (int i = 1; i < start; i++) {
            if (now + A <= arr[i]) {
                temp++;
                now += A;
            }
        }

        // 수면 시간 추가
        now += B * x;

        // 잠잔 후 과제
        for (int i = start; i <= N; i++) {
            if (now + (A - x) <= arr[i]) {
                temp++;
                now += (A - x);
            }
        }

        return temp;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
    }
}
