import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] arr;
    static int[] nums;
    public static void main(String[] args) throws Exception{
            init();
            solve();
        }

    private static void solve() {
        for (int i = 0; i < N; i++) {
            int name = arr[i];
            int idx = 0;

            while (name > 0) {
                nums[idx++] += name % 2;
                name /= 2;
            }
        }

        long answer = 0;
        for (int i = 19; i >= 0; i--) {
            answer += (long) nums[i] * (N - nums[i]);

            answer <<= 1;
        }
        System.out.println(answer / 2);
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        nums = new int[20];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
    }
}
