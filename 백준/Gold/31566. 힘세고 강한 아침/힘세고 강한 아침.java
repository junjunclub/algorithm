import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 987_654_321;
    static int N, M, Q;
    static int[][] board;
    static int[][][] dist;

    public static void main(String[] args) throws Exception{
        init();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        board = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            Arrays.fill(board[i], INF);
            board[i][i] = 0;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            board[s][e] = Math.min(w, board[s][e]);
        }

        dist = new int[N + 1][N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            dist[i] = floydWithout(i);
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            if (dist[k][s][e] == INF) {
                System.out.println("No");
            } else {
                System.out.println(dist[k][s][e]);
            }
        }
    }

    private static int[][] floydWithout(int f) {
        int[][] d = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                d[i][j] = board[i][j];
            }
        }

        for (int i = 1; i <= N; i++) {
            d[i][f] = INF;
            d[f][i] = INF;
        }

        for (int k = 1; k <= N; k++) {
            if (k == f) continue;
            for (int i = 1; i <= N; i++) {
                if (i == f) continue;
                for (int j = 1; j <= N; j++) {
                    if (j == f) continue;
                    d[i][j] = Math.min(d[i][k] + d[k][j], d[i][j]);
                }
            }
        }

        return d;
    }
}
