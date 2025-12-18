import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static List<Integer>[] light, heavy;
    static StringBuilder sb = new StringBuilder();
    static Set<Integer> set;
    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    private static void solve() {
        for (int i = 1; i <= N; i++) {
            set = new HashSet<>();
            set.add(i);
            dfs(i, true);
            dfs(i, false);
            sb.append(N - set.size()).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int i, boolean flag) {
        if (flag) {
            for (int next : heavy[i]) {
                if (!set.contains(next)) {
                    set.add(next);
                    dfs(next, flag);
                }
            }
        } else {
            for (int next : light[i]) {
                if (!set.contains(next)) {
                    set.add(next);
                    dfs(next, flag);
                }
            }
        }
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        light = new List[N + 1];
        heavy = new List[N + 1];

        for (int i = 1; i <= N; i++) {
            light[i] = new ArrayList<>();
            heavy[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int h = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            light[h].add(l);
            heavy[l].add(h);
        }
    }
}