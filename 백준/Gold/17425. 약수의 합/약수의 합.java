import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long[] sum;
    static long[] list;
    static int[] answer;
    public static void main(String[] args) throws Exception{
            init();
            solve();
        /**
         * 전처리
         * 1. 1~100000까지 f(a)값을 구한다.
         * 2. 누적합 배열을 만든다.
         * 3. 답 출력
         */
    }

    private static void solve() {
        StringBuilder sb = new StringBuilder();
        list = new long[1000001];
        sum = new long[1000001];

        Arrays.fill(list, 1);

        for (int i = 2; i <= 1000000; i++) {
            for (int j = 1; i*j <= 1000000; j++) {
                list[i*j] += i;
            }
        }

        for (int i = 1; i <= 1000000; i++) {
            sum[i] += sum[i-1] + list[i];
        }

        for (int i = 0; i < N; i++) {
            sb.append(sum[answer[i]]).append("\n");
        }
        System.out.println(sb);
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = Integer.parseInt(br.readLine());
        }
    }
}
