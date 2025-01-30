import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static int t, m, n, answer;
    static int[] pizza1, pizza2, sumV1, sumV2, total1, total2;
    public static void main(String[] args) throws IOException {
        init();
        solve();

        /**
         * 1. 누적합 배열 만들기
         * 2. 피자 사이즈 합계가 인덱스, 갯수가 값인 배열을 만들기
         * 3. A[t], B[t], A[t-i] * B[i] 값 구하기?
         */
    }

    private static void solve() {
        answer = 0;
        totalArr(total1, sumV1, m);
        totalArr(total2, sumV2, n);

        answer += total1[t];
        answer += total2[t];

        for (int i = 1; i < t; i++) {
            int j = t - i;
            answer += total1[i] * total2[j];
        }

        System.out.println(answer);
    }

    private static void totalArr(int[] tem, int[] s, int m) {
        for (int i = 1; i < m; i++) { // 갯수
            for (int j = 1; j <= m; j++) { // 시작 인덱스
                int temp = s[j + i - 1] - s[j - 1];
                if (temp > t) {
                    continue;
                }
                tem[temp]++;
            }
        }

        if (s[m] <= t) tem[s[m]]++;
    }

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        pizza1 = new int[2 * m + 1];
        pizza2 = new int[2 * n + 1];

        sumV1 = new int[2 * m + 1];
        sumV2 = new int[2 * n + 1];
        total1 = new int[t + 1];
        total2 = new int[t + 1];

        for (int i = 1; i <= m; i++) {
            pizza1[i] = pizza1[i + m] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= n; i++) {
            pizza2[i] = pizza2[i + n] = Integer.parseInt(br.readLine());
        }

        sumV1[1] = pizza1[1];
        sumV2[1] = pizza2[1];

        for (int i = 2; i <= 2 * m; i++) {
            sumV1[i] = sumV1[i-1] + pizza1[i];
        }

        for (int i = 2; i <= 2 * n; i++) {
            sumV2[i] = sumV2[i-1] + pizza2[i];
        }
    }
}
