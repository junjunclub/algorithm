import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int M, N;
    static int[][] board1, board2;
    static int[][] list;
    public static void main(String[] args) throws Exception{
        init();
        solve();
    }

    private static void solve() {
        int[] sum = new int[2 * M -1];
        for (int i = 0; i < N; i++) {
            int zero = list[i][0];
            int one = list[i][1];
            int two = list[i][2];

            int idx = 0;

            for (int j = 0; j < zero; j++) {
                sum[idx++] += 0;
            }
            for (int j = 0; j < one; j++) {
                sum[idx++] += 1;
            }
            for (int j = 0; j < two; j++) {
                sum[idx++] += 2;
            }
        }
        int r = M - 1;
        int c = 0;
        for (int i = 0; i < 2 * M - 1; i++) {
            board1[r][c] += sum[i];

            if (r != 0) {
                r--;
            } else {
                c++;
            }
        }

        for (int i = 1; i < M; i++) {
            for (int j = 1; j < M; j++) {
                board1[i][j] = Math.max(board1[i-1][j], board1[i][j-1]);
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                board1[i][j]++;
            }
        }
        print(board1);
    }

    private static void print(int[][] board) {
        for (int j = 0; j < M; j++) {
            for (int k = 0; k < M; k++) {
                System.out.print(board[j][k]);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        board1 = new int[M][M];
//        for (int i = 0; i < M; i++) {
//            Arrays.fill(board1[i], 1);
//        }
        board2 = new int[M][M];

        list = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list[i][0] = Integer.parseInt(st.nextToken());
            list[i][1] = Integer.parseInt(st.nextToken());
            list[i][2] = Integer.parseInt(st.nextToken());
        }
    }
}
