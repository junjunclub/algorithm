import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[9][9];
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 0) {
                }
            }
        }
        /**
         * 1. 채워야 할 좌표에 1~9까지 값을 넣어본다.
         * 2. 검증 후 가지치기
         *
         * 비트마스킹으로도 풀 수 있을 것 같은데?
         */
        dfs(0, 0);
    }

    private static void dfs(int r, int c) {
        if (c == 9) {
            dfs(r+1, 0);
            return;
        }

        if (r == 9) {
            print();
            System.exit(0);
            return;
        }

        if (board[r][c] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (validate(r, c, i)) {
                    board[r][c] = i;
                    dfs(r, c+1);
                }
            }
            board[r][c] = 0;
            return;
        }
        dfs(r, c+1);
    }

    private static boolean validate(int r, int c, int v) {
        //가로 체크
        for (int i = 0; i < 9; i++) {
            if (board[r][i] == v) {
                return false;
            }
        }

        //세로 체크
        for (int i = 0; i < 9; i++) {
            if (board[i][c] == v) {
                return false;
            }
        }

        //네모 체크
        int vr = (r / 3) * 3;
        int vc = (c / 3) * 3;
        for (int i = vr; i <= vr + 2; i++) {
            for (int j = vc ; j <= vc + 2; j++) {
                if (board[i][j] == v) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void print() {
        sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(board[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}