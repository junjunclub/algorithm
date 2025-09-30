import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K, ans;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};
    static int[][] board;
    static List<Ruby> list = new ArrayList<>();
    static boolean[][] visited;

    static class Ruby {
        int r, c, v;

        public Ruby(int r, int c, int v) {
            this.r = r;
            this.c = c;
            this.v = v;
        }
    }

    public static void main(String[] args) throws Exception{
        init();
        solve();
    }

    private static void solve() {
        dfs(0, 0, 0);

        System.out.println(ans);
    }

    private static void dfs(int index, int depth, int v) {
        if (index == list.size() || depth == K) {
            ans = Math.max(ans, v);
            return;
        }

        Ruby r = list.get(index);

        if (canPick(r.r, r.c)) {
            visited[r.r][r.c] = true;
            dfs(index + 1, depth + 1, v + board[r.r][r.c]);
            visited[r.r][r.c] = false;
        }
        dfs(index + 1, depth, v);
    }

    private static boolean canPick (int r, int c) {
        if (visited[r][c]) return false;

        for (int i = 0; i < 4; i++) {
            int newR = r + dr[i];
            int newC = c + dc[i];

            if (0 > newR || newR >= N || 0 > newC || newC >= M) continue;
            if (visited[newR][newC]) return false;
        }
        return true;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        visited = new boolean[N][M];
        ans = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                list.add(new Ruby(i, j, board[i][j]));
            }
        }

        list.sort((a, b) -> b.v - a.v);

        if (list.size() > K * 5) {
            list = list.subList(0, K * 5);
        }
    }
}
