import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int r1, c1, r2, c2, ans;
    static class Node {
        int r, c;

        public Node (int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static int[][] visited;
    static int[] dr1 = {1, -1, 0, 0};
    static int[] dc1 = {0, 0, 1, -1};
    static int[] dr2 = {1, 1, -1, -1, 1, -1, 1, -1};
    static int[] dc2 = {1, -1, 1, -1, 1, 1, -1, -1};

    public static void main(String[] args) throws Exception{
            init();
            solve();
        }

    private static void solve() {
        ans = -1;
        bfs(r1, c1, r2, c2);
        System.out.println(ans);
    }

    private static void bfs(int x1, int y1, int x2, int y2) {
        Node n = new Node(x1, y1);

        Deque<Node> q = new ArrayDeque<>();
        q.add(n);
        visited[x1][y1] = 1;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.r == x2 && cur.c == y2) {
                ans = visited[x2][y2] - 1;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nr = cur.r;
                int nc = cur.c;

                int br = nr + dr1[i];
                int bc = nc + dc1[i];


                if (br < 0 || br >= 10 || bc < 0 || bc >= 9) continue;

                if (br == x2 && bc == y2) continue;

                for (int j = 0; j < 2; j++) {
                    int mr = br + dr2[i * 2 + j];
                    int mc = bc + dc2[i * 2 + j];

                    if (mr < 0 || mr >= 10 || mc < 0 || mc >= 9) continue;

                    if (mr == x2 && mc == y2) continue;

                    int fr = mr + dr2[i * 2 + j];
                    int fc = mc + dc2[i * 2 + j];

                    if (fr < 0 || fr >= 10 || fc < 0 || fc >= 9) continue;
                    if (visited[fr][fc] != 0) continue;

                    visited[fr][fc] = visited[cur.r][cur.c] + 1;
                    q.add(new Node(fr, fc));
                }
            }
        }
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        visited = new int[10][9];
    }
}
