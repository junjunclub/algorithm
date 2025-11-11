import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, blankCnt, ans;
    static char[][] board;
    static boolean[][] visited;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception{
        init();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase = 1;

        String input;
        while ((input = br.readLine()) != null) {
            st = new StringTokenizer(input);

            blankCnt = 0;
            ans = Integer.MAX_VALUE;
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            board = new char[N][M];
            visited = new boolean[N][M];

            for (int i = 0; i < N; i++) {
                board[i] = br.readLine().toCharArray();
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (board[i][j] == '.') blankCnt++;
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (board[i][j] == '.') {
                        visited[i][j] = true;
                        dfs(i, j, 0, 1);
                        visited[i][j] = false;
                    }
                }
            }

            if (ans == Integer.MAX_VALUE) ans = -1;
            System.out.println("Case "+testCase+": "+ans);
            testCase++;
        }
    }

    private static void dfs(int r, int c, int cnt, int visitCnt) {
        if (visitCnt == blankCnt) {
            ans = Math.min(ans, cnt);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nr = r;
            int nc = c;
            int move = 0;

            while (true) {
                int newR = nr + dr[i];
                int newC = nc + dc[i];

                if (0 > newR || 0 > newC || newR >= N || newC >= M) break;
                if (board[newR][newC] == '*') break;
                if (visited[newR][newC]) break;

                nr = newR;
                nc = newC;
                visited[nr][nc] = true;
                move++;
            }

            if (move > 0) {

                dfs(nr, nc, cnt + 1, visitCnt + move);

                int br = r;
                int bc = c;
                for (int j = 0; j < move; j++) {
                    br += dr[i];
                    bc += dc[i];
                    visited[br][bc] = false;
                }
            }
        }
    }
}
