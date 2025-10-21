import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int r, c;
        public Node (int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int[] dr = {-1, 0, 1};

    static int N, M, ans;
    static boolean flag;
    static char[][] board;
    public static void main(String[] args) throws Exception{
        init();
        solve();
    }

    private static void solve() {
        ans = 0;

        for (int i = 0; i < N; i++) {
            flag = false;
            dfs(i, 0);
        }

        System.out.println(ans);
    }

    private static void dfs(int r, int c) {
        board[r][c] = '-';

        if (c == M - 1) {
            ans++;
            flag = true;
        }
        
        for (int i = 0; i < 3; i++) {
            int newR = r + dr[i];
            int newC = c + 1;

            if (newR < 0 || newC < 0 || newR >= N || newC >= M) continue;
            if (board[newR][newC] != '.') continue;

            dfs(r + dr[i], c + 1);
            if (flag) return;
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }
    }
}
