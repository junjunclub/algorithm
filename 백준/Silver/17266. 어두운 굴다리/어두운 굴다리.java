import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 1;
        int end = n;
        int result = 0;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (check(mid)) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(result);
    }
    static boolean check(int t) {
        int prev = 0;

        for (int i = 0; i < m; i++) {
            if (arr[i] - t <= prev) {
                prev = arr[i] + t;
            } else {
                return false;
            }
        }
        return n - prev <= 0;
    }
}
