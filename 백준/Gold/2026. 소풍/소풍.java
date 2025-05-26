import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K, F;
    static List<Integer>[] list;
    static List<Integer> team = new ArrayList<>();
    static boolean found = false;
    public static void main(String[] args) throws Exception{
        init();
        solve();
    }

    private static void solve() {
        for (int i = 1; i <= N; i++) {
            team.add(i);
            dfs(i, 1);
            team.remove(team.size() - 1);
            if (found) break;
        }

        if (!found) {
            System.out.println(-1);
        }
    }

    private static void dfs(int n, int depth) {
        if (found) return;
        if (depth == K) {
            found = true;
            Collections.sort(team);
            for (int i = 0; i < team.size(); i++) {
                System.out.println(team.get(i));
            }
            return;
        }

        for (int i = n + 1; i <= N; i++) {
            boolean canTeam = true;

            for (int num : team) {
                if (!list[num].contains(i)) {
                    canTeam = false;
                    break;
                }
            }

            if (canTeam) {
                team.add(i);
                dfs(i, depth + 1);
                team.remove(team.size() - 1);
            }
        }
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        F = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0 ; i < F; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            list[s].add(e);
            list[e].add(s);
        }
    }
}
