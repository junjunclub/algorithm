import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K, ans;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};
    static int[][] board;
    static int maxV;
    static boolean[][] visited;

    static class Cell {
        int r, c, val;
        Cell(int r, int c, int val) {
            this.r = r; this.c = c; this.val = val;
        }
    }

    static List<Cell> candidates = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    private static void solve() {
        dfs(0, 0, 0);
        System.out.println(ans);
    }

    private static void dfs(int idx, int depth, int sum) {
        if (depth == K || idx == candidates.size()) {
            ans = Math.max(ans, sum);
            return;
        }

        Cell cell = candidates.get(idx);

        if (canPick(cell.r, cell.c)) {
            visited[cell.r][cell.c] = true;
            dfs(idx + 1, depth + 1, sum + cell.val);
            visited[cell.r][cell.c] = false;
        }

        dfs(idx + 1, depth, sum);
    }

    private static boolean canPick(int r, int c) {
        if (visited[r][c]) return false;
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
            if (visited[nr][nc]) return false;
        }
        return true;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        maxV = K * 5;

        board = new int[N][M];
        visited = new boolean[N][M];
        ans = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                candidates.add(new Cell(i, j, board[i][j]));
            }
        }

        candidates.sort((a, b) -> b.val - a.val);

        if (candidates.size() > maxV) {
            candidates = candidates.subList(0, maxV);
        }
    }
}