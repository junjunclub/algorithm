import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static BufferedReader br;
    static StringBuilder sb;
    static int n;
    static long[] dp1;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() throws IOException {
        sb = new StringBuilder();
        dp1 = new long[101];
        Arrays.fill(dp1, Long.MAX_VALUE);
        dp1[0] = 0;
        dp1[1] = 0;
        dp1[2] = 1;
        dp1[3] = 7;
        dp1[4] = 4;
        dp1[5] = 2;
        dp1[6] = 6;
        dp1[7] = 8;
        dp1[8] = 10;

        String[] list = {"1", "7", "4", "2", "0", "8"};

        for (int i = 9; i < 101; i++) {
            for (int j = 2; j <= 7; j++) {
                String temp = ""+ dp1[i-j] + list[j-2];
                dp1[i] = Math.min(Long.parseLong(temp), dp1[i]);
            }
        }



        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int num = Integer.parseInt(br.readLine());

            int a = num % 2;
            int b = num / 2;

            if (a == 1) {
                sb.append("7");
            } else {
                sb.append("1");
            }

            for (int j = 0; j < b - 1; j++) {
                sb.append("1");
            }

            System.out.println(dp1[num]+ " "+ sb);
        }
    }

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
    }
}
