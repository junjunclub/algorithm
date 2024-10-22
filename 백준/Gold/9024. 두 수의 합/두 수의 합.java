import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static long[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long m = Long.parseLong(st.nextToken());
            list = new long[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                list[i] = Long.parseLong(st.nextToken());
            }

            Arrays.sort(list);
            int s = 0;
            int e = n-1;
            long number = 0;
            long answer = Long.MAX_VALUE;
            while (s < e) {
                long value = list[s]+list[e];
                if (answer >= Math.abs(m-value)) {
                    if (answer > Math.abs(m-value)) {
                        number = 0;
                    }
                    number++;
                    answer = Math.abs(m-value);
                }
                if (value >= m) {
                    e--;
                } else {
                    s++;
                }
            }
            System.out.println(number);
        }
    }
}
