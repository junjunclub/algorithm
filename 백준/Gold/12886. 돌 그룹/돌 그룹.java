import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int A, B, C;
    static boolean flag;
    public static void main(String[] args) throws Exception{
            init();
            solve();
        }

    private static void solve() {
        int sum = A + B + C;

        if (sum % 3 != 0) {
            System.out.println(0);
            return;
        }

        bfs();
    }

    private static void bfs() {
        int sum = A + B + C;

        boolean[][] visited = new boolean[1501][1501];
        Deque<int[]> q = new ArrayDeque<>();

        int[] v = new int[]{A, B, C};
        Arrays.sort(v);

        q.add(v);

        visited[v[1]][v[2]] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int a = now[0];
            int b = now[1];
            int c = now[2];

            if (a == b && b == c) {
                System.out.println(1);
                return;
            }

            int[][] pairs = {{a, b, c}, {a, c, b}, {b, c, a}};

            for (int[] p : pairs) {
                int x = p[0];
                int y = p[1];
                int z = p[2];

                if (x == y) continue;

                int big = Math.max(x, y);
                int small = Math.min(x, y);
                
                int newX = small + small;
                int newY = big - small;
                int newZ = z;

                int[] next = {newX, newY, newZ};

                Arrays.sort(next);

                if (!visited[next[0]][next[1]]) {
                    visited[next[0]][next[1]] = true;
                    q.add(next);
                }
            }
        }
        System.out.println(0);
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        flag = false;
    }
}
