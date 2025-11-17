import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parents = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        int ans = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            if (find(s) == find(e)) {
                ans++;
            } else {
                union(s, e);
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            set.add(find(i));
        }

        ans += set.size() - 1;

        System.out.println(ans);
    }

    private static void union (int x, int y) {
        int fx = find(x);
        int fy = find(y);

        if (fx < fy) {
            parents[fy] = fx;
        } else {
            parents[fx] = fy;
        }
    }

    private static int find(int x) {
        if (x == parents[x]) {
            return parents[x];
        }
        return parents[x] = find(parents[x]);
    }
}