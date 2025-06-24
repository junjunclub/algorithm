import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int T;
    public static void main(String[] args) throws Exception{
            init();
        }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            long n = Long.parseLong(br.readLine());
            long ans = binarySearch(n);
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }

    private static long binarySearch(long n) {
        long start = 1;
        long end = ((long) Math.sqrt(1 - (4 * n * -2)) + 1) / 2;
        long ans = 0;
        while (start <= end) {
            long mid = (start + end) / 2;
            long sumV = mid * (mid + 1) / 2;

            if (sumV <= n) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }
}
