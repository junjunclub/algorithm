import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static char[][] board;
    static int answer = 0;
    public static void main(String[] args) throws Exception{
        init();
        solve();
    }

    private static void solve() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i < N - 1) {
                    swap(i, j, i + 1, j);
                    calculate();
                    swap(i, j, i + 1, j);
                }

                if (j < N - 1) {
                    swap(i, j, i, j + 1);
                    calculate();
                    swap(i, j, i, j + 1);
                }
            }
        }
        System.out.println(answer);
    }

    private static void calculate() {
        int temp = 1;
        for (int i = 0; i < N; i++) {
            int v = 1;
            for (int j = 1; j < N; j++) {
                if (board[i][j] == board[i][j-1]) {
                    v++;
                    temp = Math.max(v, temp);
                } else {
                    v = 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            int v = 1;
            for (int j = 1; j < N; j++) {
                if (board[j][i] == board[j-1][i]) {
                    v++;
                    temp = Math.max(v, temp);
                } else {
                    v = 1;
                }
            }
        }
        answer = Math.max(temp, answer);
    }

    private static void swap(int r1, int c1, int r2, int c2) {
        char temp = board[r2][c2];
        board[r2][c2] = board[r1][c1];
        board[r1][c1] = temp;
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new char[N][N];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }
    }
}
