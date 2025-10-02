import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C, T, ans, curR, curC;
    static char[][] board;
    static int[] dr = {0, 0, -1, 1, 0};
    static int[] dc = {-1, 1, 0, 0, 0};
    static boolean[][] visited;

    public static void main(String[] args) throws Exception{
        init();
        solve();
    }

    private static void solve() {
        game(curR, curC, 0, 0);

        System.out.println(ans);
    }

    private static void game(int r, int c, int depth, int v) {
        if (depth == T) {
            ans = Math.max(ans, v);
            return;
        }

        for (int i = 0; i < 5; i++) {
            int newR = r + dr[i];
            int newC = c + dc[i];

            if (0 > newR || 0 > newC || newR >= R || newC >= C) continue;

            if (board[newR][newC] == '#') continue;
            if (board[newR][newC] == 'S' && visited[newR][newC]) {
                visited[newR][newC] = false;
                game(newR, newC, depth + 1, v + 1);
                visited[newR][newC] = true;
            } else {
                game(newR, newC, depth + 1, v);
            }
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        ans = 0;

        board = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = input.charAt(j);
                if (board[i][j] == 'G') {
                    curR = i;
                    curC = j;
                } else if (board[i][j] == 'S') {
                    visited[i][j] = true;
                }
            }
        }
    }
}
