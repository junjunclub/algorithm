import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[] parents;
    static List<Integer>[] friends, enemies;
    public static void main(String[] args) throws Exception{
        init();
        solve();
    }

    private static void solve() {
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < enemies[i].size(); j++) {
                for (int k = 0; k < enemies[enemies[i].get(j)].size(); k++) {
                    if (enemies[enemies[i].get(j)].get(k) == i) continue;
                    union(enemies[enemies[i].get(j)].get(k), i);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < friends[i].size(); j++) {
                union(i, friends[i].get(j));
            }
        }
        Set<Integer> set = new HashSet<>();
        
        for (int i = 1; i <= N; i++) {
            set.add(parents[i]);
        }
        
        System.out.println(set.size());
    }

    private static void union(int x, int y) {
        int findx = find(x);
        int findy = find(y);

        if (findx > findy) {
            parents[findx] = findy;
        } else {
            parents[findy] = findx;
        }
    }

    private static int find(int x) {
        if (x != parents[x]) {
            return parents[x] = find(parents[x]);
        }
        return x;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        friends = new List[N + 1];
        enemies = new List[N + 1];
        parents = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            friends[i] = new ArrayList<>();
            enemies[i] = new ArrayList<>();
            parents[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (command.equals("F")) {
                friends[a].add(b);
                friends[b].add(a);
            } else {
                enemies[a].add(b);
                enemies[b].add(a);
            }
        }
    }
}
