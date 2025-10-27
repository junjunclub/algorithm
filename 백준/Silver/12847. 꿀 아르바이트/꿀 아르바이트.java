import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] list = new long[N];
        long[] sum = new long[N+1];

        st = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            int t = Integer.parseInt(st.nextToken());
            list[i] = t;
            sum[i+1] = sum[i] + list[i];
        }

        long max = 0;
        for (int i = 0; i < N - M + 1; i++) {
            long temp = sum[i+M] - sum[i];
            max = Math.max(max, temp);
        }
        System.out.println(max);
    }
}