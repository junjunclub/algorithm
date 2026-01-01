import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static long[] prefix;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
            init();
            solve();
        }

    private static void solve() {
        System.out.println(sb);
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        prefix = new long[N + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }

        for (int i = 0; i < M; i++) {
            int n = Integer.parseInt(br.readLine());

            int target = binarySearch(n);

            int res = target + 1;

            long left = prefix[res];
            long right = prefix[N] - prefix[res];

            long leftV = (long) n * res - left;
            long rightV = right - (long) n * (N - res);

            sb.append(leftV + rightV).append("\n");
        }
    }

    private static int binarySearch(int n) {
        int start = 0;
        int end = N - 1;
        int res = -1;

        while (start <= end) {
            int mid = (start + end) >>> 1;

            if (arr[mid] <= n) {
                res = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return res;
    }
}
