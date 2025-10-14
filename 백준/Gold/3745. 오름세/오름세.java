import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String input;
        StringBuilder sb = new StringBuilder();

        while ((input = br.readLine()) != null) {
            input = input.trim();
            if (input.isEmpty()) continue;

            int N = Integer.parseInt(input);
            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dp = new int[N + 1];
            
            int len = 0;
            int idx = 0;

            for (int i = 0; i < N; i++) {
                if (arr[i] > dp[len]) {
                    dp[++len] = arr[i];
                } else {
                    idx = binarySearch(0, len, arr[i]);
                    dp[idx] = arr[i];
                }
            }
            sb.append(len).append("\n");
        }
        System.out.println(sb);
    }

    private static int binarySearch(int s, int e, int v) {
        while (s < e) {
            int mid = (s + e) / 2;
            
            if (dp[mid] >= v) {
                e = mid;
            } else {
                s = mid + 1;
            }
        }
        
        return e;
    }
}