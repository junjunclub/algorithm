import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int[] tops;
    public static void main(String[] args) throws Exception{
            init();
            solve();
        }

    private static void solve() {
        int answer = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j <= N; j++) {
                int dist = tops[j] - tops[i];
                int reverse = tops[N] - dist;

                int temp = Math.min(dist, reverse);
                answer = Math.max(temp, answer);
            }
        }
        System.out.println(answer);
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tops = new int[N+1];

        for (int i = 1; i <= N; i++) {
            tops[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i < N; i++) {
            tops[i+1] += tops[i];
        }
    }
}
