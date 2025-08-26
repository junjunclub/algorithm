import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int[][] jarr, iarr, oarr;
    static char[][] board;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    private static void solve() {
        System.out.println(sb);
    }

    private static void init() throws IOException {
        sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        board = new char[M][N];

        jarr = new int[M][N];
        iarr = new int[M][N];
        oarr = new int[M][N];

        for (int i = 0; i < M; i++) {
            board[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                int jval = 0, oval = 0, ival = 0;
                if (board[i][j] == 'J') jval = 1;
                if (board[i][j] == 'O') oval = 1;
                if (board[i][j] == 'I') ival = 1;

                jarr[i][j] = jval;
                oarr[i][j] = oval;
                iarr[i][j] = ival;

                if (i > 0) {
                    jarr[i][j] += jarr[i - 1][j];
                    oarr[i][j] += oarr[i - 1][j];
                    iarr[i][j] += iarr[i - 1][j];
                }
                if (j > 0) {
                    jarr[i][j] += jarr[i][j - 1];
                    oarr[i][j] += oarr[i][j - 1];
                    iarr[i][j] += iarr[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    jarr[i][j] -= jarr[i - 1][j - 1];
                    oarr[i][j] -= oarr[i - 1][j - 1];
                    iarr[i][j] -= iarr[i - 1][j - 1];
                }
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken()) - 1;
            int c1 = Integer.parseInt(st.nextToken()) - 1;
            int r2 = Integer.parseInt(st.nextToken()) - 1;
            int c2 = Integer.parseInt(st.nextToken()) - 1;

            int jVal = jarr[r2][c2];
            int oVal = oarr[r2][c2];
            int iVal = iarr[r2][c2];

            if (r1 > 0) {
                jVal -= jarr[r1 - 1][c2];
                oVal -= oarr[r1 - 1][c2];
                iVal -= iarr[r1 - 1][c2];
            }

            if (c1 > 0) {
                jVal -= jarr[r2][c1 - 1];
                oVal -= oarr[r2][c1 - 1];
                iVal -= iarr[r2][c1 - 1];
            }

            if (r1 > 0 && c1 > 0) {
                jVal += jarr[r1 - 1][c1 - 1];
                oVal += oarr[r1 - 1][c1 - 1];
                iVal += iarr[r1 - 1][c1 - 1];
            }
            sb.append(jVal).append(" ").append(oVal).append(" ").append(iVal);
            sb.append("\n");
        }
    }
}