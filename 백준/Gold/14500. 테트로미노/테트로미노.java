import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, answer;
    static int[][] board;
    public static void main(String[] args) throws Exception{
        init();
        solve();
    }

    private static void solve() {
        answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                aType(i, j);

                bType(i, j);

                cType(i, j);

                dType(i, j);

                eType(i, j);

            }
        }
        System.out.println(answer);
    }

    private static void eType(int r, int c) {
        if (range(r, c + 1) && range(r, c + 2) && range(r - 1, c + 1)) {
            answer = Math.max(answer, board[r][c] + board[r][c + 1] + board[r][c + 2] + board[r - 1][c + 1]);
        }

        if (range(r, c + 1) && range(r, c + 2) && range(r + 1, c + 1)) {
            answer = Math.max(answer, board[r][c] + board[r][c + 1] + board[r][c + 2] + board[r + 1][c + 1]);
        }

        if (range(r + 1, c) && range(r + 2, c) && range(r + 1, c + 1)) {
            answer = Math.max(answer, board[r][c] + board[r + 1][c] + board[r + 2][c] + board[r + 1][c + 1]);
        }

        if (range(r + 1, c) && range(r + 2, c) && range(r + 1, c - 1)) {
            answer = Math.max(answer, board[r][c] + board[r + 1][c] + board[r + 2][c] + board[r + 1][c - 1]);
        }
    }

    private static void dType(int r, int c) {
        if (range(r + 1, c) && range(r + 1, c + 1) && range(r + 2, c + 1)) {
            answer = Math.max(answer, board[r][c] + board[r + 1][c] + board[r + 1][c + 1] + board[r + 2][c + 1]);
        }

        if (range(r + 1, c) && range(r + 1, c - 1) && range(r + 2, c - 1)) {
            answer = Math.max(answer, board[r][c] + board[r + 1][c] + board[r + 1][c - 1] + board[r + 2][c - 1]);
        }

        if (range(r, c + 1) && range(r - 1, c + 1) && range(r - 1, c + 2)) {
            answer = Math.max(answer, board[r][c] + board[r][c + 1] + board[r - 1][c + 1] + board[r - 1][c + 2]);
        }

        if (range(r, c + 1) && range(r + 1, c + 1) && range(r + 1, c + 2)) {
            answer = Math.max(answer, board[r][c] + board[r][c + 1] + board[r + 1][c + 1] + board[r + 1][c + 2]);
        }
    }

    private static void cType(int r, int c) {
        if (range(r + 1, c) && range(r + 2, c) && range(r + 2, c + 1)) {
            answer = Math.max(answer, board[r][c] + board[r + 1][c] + board[r + 2][c] + board[r + 2][c + 1]);
        }

        if (range(r + 1, c) && range(r + 2, c) && range(r + 2, c - 1)) {
            answer = Math.max(answer, board[r][c] + board[r + 1][c] + board[r + 2][c] + board[r + 2][c - 1]);
        }

        if (range(r + 1, c) && range(r, c + 1) && range(r, c + 2)) {
            answer = Math.max(answer, board[r][c] + board[r + 1][c] + board[r][c + 1] + board[r][c + 2]);
        }

        if (range(r + 1, c + 2) && range(r, c + 1) && range(r, c + 2)) {
            answer = Math.max(answer, board[r][c] + board[r + 1][c + 2] + board[r][c + 1] + board[r][c + 2]);
        }

        if (range(r, c + 1) && range(r + 1, c) && range(r + 2, c)) {
            answer = Math.max(answer, board[r][c] + board[r + 1][c] + board[r + 2][c] + board[r][c + 1]);
        }

        if (range(r, c + 1) && range(r + 1, c + 1) && range(r + 2, c + 1)) {
            answer = Math.max(answer, board[r][c] + board[r + 1][c + 1] + board[r + 2][c + 1] + board[r][c + 1]);
        }

        if (range(r + 1, c) && range(r + 1, c + 1) && range(r + 1, c + 2)) {
            answer = Math.max(answer, board[r][c] + board[r + 1][c] + board[r + 1][c + 1] + board[r + 1][c + 2]);
        }

        if (range(r + 1, c) && range(r + 1, c - 1) && range(r + 1, c - 2)) {
            answer = Math.max(answer, board[r][c] + board[r + 1][c] + board[r + 1][c - 1] + board[r + 1][c - 2]);
        }
    }

    private static void bType(int r, int c) {
        int temp = 0;
        boolean flag = true;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (!flag) return;
                if (range(r + i, c + j)) {
                    temp += board[r + i][c + j];
                } else {
                    flag = false;
                }
            }
        }
        if (flag) {
            answer = Math.max(answer, temp);
        }
    }

    private static void aType(int r, int c) {
        int temp = 0;
        boolean flag = true;
        for (int i = 0; i < 4; i++) {
            if (!flag) break;
            if (range(r + i, c)) {
                temp += board[r + i][c];
            } else {
                flag = false;
            }
        }
        if (flag) {
            answer = Math.max(answer, temp);
        }

        temp = 0;
        flag = true;
        for (int i = 0; i < 4; i++) {
            if (!flag) return;
            if (range(r, c + i)) {
                temp += board[r][c + i];
            } else {
                flag = false;
            }
        }
        if (flag) {
            answer = Math.max(answer, temp);
        }
    }

    private static boolean range(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
