import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int year, month;
        int[] dp = new int[120002];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            String e = st.nextToken();
            year = Integer.parseInt(s.split("-")[0]);
            month = Integer.parseInt(s.split("-")[1]);
            dp[year * 12 + month]++;
            year = Integer.parseInt(e.split("-")[0]);
            month = Integer.parseInt(e.split("-")[1]);
            dp[year * 12 + month + 1]--;
        }

        int maxV = 0;
        year = 0;
        month = 0;
        for (int i = 24000; i < 120001; i++) {
            dp[i] += dp[i-1];

            if (dp[i] > maxV) {
                year = i / 12;
                month = i % 12;
                maxV = dp[i];
            }
        }

        if (month == 0) {
            month = 12;
            year--;
        }

        String answer;

        if (month < 10) {
            answer = year +"-0"+ month;
        } else {
            answer = year +"-"+ month;
        }

        System.out.println(answer);
    }
}
