import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int r, c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int[] dr = {0, 1, 1, 1, 0, -1, -1, -1, 0};
    static int[] dc = {0, -1, 1, 0, 1, -1, 1, 0, -1};

    static char[][] board = new char[8][8];
    static boolean ans;

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 8; i++) {
            board[i] = br.readLine().toCharArray();
        }
    }

    private static void solve() {
        bfs();
        System.out.println(ans ? 1 : 0);
    }

    private static void bfs() {
        Deque<Node> q = new ArrayDeque<>();
        q.add(new Node(7, 0));

        while (!q.isEmpty()) {
            int size = q.size();
            boolean[][] visited = new boolean[8][8];

            for (int s = 0; s < size; s++) {
                Node cur = q.pollFirst();

                if (board[cur.r][cur.c] == '#') continue;

                if (cur.r == 0 && cur.c == 7) {
                    ans = true;
                    return;
                }

                for (int i = 0; i < 9; i++) {
                    int nr = cur.r + dr[i];
                    int nc = cur.c + dc[i];

                    if (nr < 0 || nc < 0 || nr >= 8 || nc >= 8) continue;
                    if (board[nr][nc] == '#') continue;
                    if (visited[nr][nc]) continue;

                    visited[nr][nc] = true;
                    q.add(new Node(nr, nc));
                }
            }
            moveWallsDown();
        }
    }

    private static void moveWallsDown() {
        for (int i = 7; i >= 1; i--) {
            board[i] = Arrays.copyOf(board[i - 1], 8);
        }
        board[0] = "........".toCharArray();
    }
}
