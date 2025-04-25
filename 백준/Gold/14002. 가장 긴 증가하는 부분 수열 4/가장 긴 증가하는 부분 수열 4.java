import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] list, dp;
    public static void main(String[] args) throws Exception{
        init();
        solve();
    }
    private static void solve() {
        int answer = 1;
        dp[0] = 1;
        for (int i = 1; i < N; i++) {

            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (list[i] > list[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    answer = Math.max(answer ,dp[i]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(answer).append("\n");
        Stack<Integer> stack = new Stack<>();
        for (int i = N-1; i >= 0; i--) {
            if (dp[i] == answer) {
                stack.push(list[i]);
                answer--;
            }
        }

        while(!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);

    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        list = new int[N];
        dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
    }
}
