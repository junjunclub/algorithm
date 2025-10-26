import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int N;
    static int maxV;
    static List<Integer> list;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    private static void solve() {
        int ans = 1;
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            int cnt = dfs(i, 0);
            if (cnt > maxV) {
                maxV = cnt;
                ans = i;
            }
        }
        System.out.println(ans);
    }

    private static int dfs(int num, int depth) {
        if (visited[num]) return depth;
        visited[num] = true;
        return dfs(list.get(num - 1), depth + 1);
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        maxV = 0;
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
    }
}