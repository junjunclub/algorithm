import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
        public static void main(String[] args) throws Exception{
            init();
            solve();
        }

        private static void init() throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            N = Integer.parseInt(br.readLine());
            arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(arr);
        }

        private static void solve() {
            int ans = 0;
            int left = 0;
            int right = N / 2;

            while (left < N / 2 && right < N) {
                if (arr[left] * 2 <= arr[right]) {
                    ans++;
                    left++;
                    right++;
                } else {
                    right++;
                }
            }

            System.out.println(N - ans);
        }
}
