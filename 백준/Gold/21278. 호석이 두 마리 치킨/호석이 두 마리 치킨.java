import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, A, B;
    static final int INF = 1_000_000_000;
    static int[][] list;
    public static void main(String[] args) throws Exception{
            init();
            solve();
        }

    private static void solve() {
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    list[i][j] = Math.min(list[i][j], list[i][k] + list[k][j]);
                }
            }
        }

        int res = INF;
        A = 0;
        B = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int temp = 0;

                for (int k = 0; k < N; k++) {
                    if (i == k || j == k) continue;

                    temp += Math.min(list[i][k], list[j][k]) * 2;
                }

                if (res > temp) {
                    res = temp;
                    A = i + 1;
                    B = j + 1;
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        sb.append(A).append(" ").append(B).append(" ").append(res);
        System.out.println(sb);
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new int[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(list[i], INF);
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    list[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            list[start][end] = 1;
            list[end][start] = 1;
        }
    }
}
