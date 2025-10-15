import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int T, N, ans;
    static int[] prev;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        init();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            prev = new int[N + 1];

            for (int j = 0; j < N - 1; j++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());

                prev[e] = s;
            }

            st = new StringTokenizer(br.readLine());
            int t1 = Integer.parseInt(st.nextToken());
            int t2 = Integer.parseInt(st.nextToken());

            ans = 0;
            visited = new boolean[N + 1];

            dfs(t1);

            dfs(t2);

            System.out.println(ans);
        }
    }

    private static void dfs(int num) {
        if (num == 0) return;

        if (visited[num]) {
            ans = num;
            return;
        }

        visited[num] = true;
        dfs(prev[num]);
    }
}
