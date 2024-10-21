import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static int[] list;
    static long maxV;
    static long result = Long.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new int[n];

        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(br.readLine());
            maxV = Math.max(maxV, list[i]);
        }

        Arrays.sort(list);

        long s = 0;
        long e = maxV * m;

        while (s <= e) {
            long sum = 0;
            long mid = (s + e) / 2;

            for (int i = 0; i < list.length; i++) {
                long cnt = mid / list[i];
                if (sum >= m) break;
                sum += cnt;
            }

            if (sum >= m) {
                e = mid - 1;
                result = Math.min(result, mid);
            } else {
                s = mid + 1;
            }
        }

        System.out.println(result);

    }
}
