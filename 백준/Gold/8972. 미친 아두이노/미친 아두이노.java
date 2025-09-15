import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node {
        int r, c;
        public Node (int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static int R, C, ir, ic;
    static int[] dr = {1, 1, 1, 0, 0, 0, -1, -1, -1};
    static int[] dc = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
    static char[][] board;
    static boolean crush;
    static String order;
    static Deque<Node> q = new ArrayDeque<>();
    public static void main(String[] args) throws Exception{
        init();
        solve();
    }

    private static void solve() {
        crush = false;
        for (int i = 0; i < order.length(); i++) {
            moveI((int) order.charAt(i));
            // 움직이고 충돌하면 터짐
            crushCheck();
            if (crush) {
                System.out.println("kraj " + (i + 1));
                return;
            }
            moveR();
            if (crush) {
                System.out.println("kraj " + (i + 1));
                return;
            }
        }

        if (!crush) {
            char[][] res = new char[R][C];

            for (int i = 0; i < R; i++) {
                Arrays.fill(res[i], '.');
            }

            for (Node n : q) {
                res[n.r][n.c] = 'R';
            }

            res[ir][ic] = 'I';

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < R; i++) {
                sb.append(res[i]).append("\n");
            }
            System.out.println(sb);
        }
    }

    private static void moveR() {
        int size = q.size();

        int[][] visited = new int[R][C];

        for (int i = 0; i < size; i++) {
            Node cur = q.pollFirst();

            int curR = cur.r;
            int curC = cur.c;

            if (curR < ir) curR++;
            else if (curR > ir) curR--;

            if (curC < ic) curC++;
            else if (curC > ic) curC--;

            if (curR == ir && curC == ic) {
                crush = true;
                return;
            }

            visited[curR][curC]++;
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (visited[i][j] == 1) {
                    q.add(new Node(i, j));
                }
            }
        }

    }

    private static void crushCheck() {
        if (q.isEmpty()) return;
        for (Node n : q) {
            if (n.r == ir && n.c == ic) {
                crush = true;
                return;
            }
        }
    }

    private static void moveI(int i) {
        int idx = i - '0';

        ir += dr[idx - 1];
        ic += dc[idx - 1];
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];

        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = input.charAt(j);
                if (board[i][j] == 'I') {
                    ir = i;
                    ic = j;
                } else if (board[i][j] == 'R') {
                    Node n = new Node(i, j);
                    q.add(n);
                }
            }
        }

        order = br.readLine();
    }
}
