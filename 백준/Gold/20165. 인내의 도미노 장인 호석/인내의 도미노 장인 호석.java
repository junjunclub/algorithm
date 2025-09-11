import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // E W S N
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static int N, M, R;
    static int[][] board;
    static boolean[][] status;
    static int ans;
    public static void main(String[] args) throws Exception{
        init();
        solve();
    }

    private static void solve() {
        StringBuilder sb = new StringBuilder();
        sb.append(ans).append("\n");

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (status[i][j]) {
                    sb.append("S").append(" ");
                } else {
                    sb.append("F").append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        status = new boolean[N][M];

        ans = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                status[i][j] = true;
            }
        }

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            String dir = st.nextToken();

            attack(x1, y1, dir);

            st = new StringTokenizer(br.readLine());
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;

            defense(x2, y2);
        }
    }

    private static void defense(int r, int c) {
        if (status[r][c]) return;
        status[r][c] = true;
    }

    private static void attack(int r, int c, String dir) {
        int d = setDirection(dir);

        if (!status[r][c]) return;

        int reach = board[r][c];
        int nr = r, nc = c;

        while (true) {
            if (nr < 0 || nr >= N || nc < 0 || nc >= M) break;

            if (status[nr][nc]) {
                status[nr][nc] = false;
                ans++;
                reach = Math.max(reach, board[nr][nc]);
            }

            reach--;
            if (reach == 0) break;

            nr += dr[d];
            nc += dc[d];
        }
    }


    private static int setDirection(String dir) {
        if (dir.equals("E")) {
            return 0;
        } else if (dir.equals("W")) {
            return 1;
        }
        else if (dir.equals("S")) {
            return 2;
        } else {
            return 3;
        }
    }
}
