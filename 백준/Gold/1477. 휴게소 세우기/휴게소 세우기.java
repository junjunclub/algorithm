import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m, l;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        init();
        solve();

        /**
         * 어려운 이분탐색....
         */
    }

    private static void solve() {
        int left = 1;
        int right = l-1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = 0;
            for (int i = 1; i < arr.length; i++) {
                cnt += (arr[i] - arr[i-1] - 1) / mid;
            }

            if (cnt <= m) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left);
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        arr = new int[n+2];
        arr[0] = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        arr[n+1] = l;
        Arrays.sort(arr);
    }
}
