import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, answer;
    static int[][] board;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0, 0};
    static int[] dc = {0, 0, -1 ,1, 0};
    public static void main(String[] args) throws Exception{
            init();
            solve();
        }

    private static void solve() {
        flower( 0, 0);
        System.out.println(answer);
    }

    private static void flower(int cnt, int value) {
        if (cnt == 3) {
            if (value < answer) {
                answer = value;
            }
            return;
        }

        if (value > answer) {
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (isPossible(i, j)) {
                    int sumV = visit(i, j);
                    flower(cnt + 1, value + sumV);
                    unvisit(i, j);
//                    flower(cnt, value);
                }
            }
        }
    }

    private static boolean isPossible(int r, int c) {
        for (int i = 0; i < 5; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (!isRange(nr, nc)) return false;
            if (visited[nr][nc])    return false;
        }
        return true;
    }

    private static boolean isRange(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

    private static void unvisit(int r, int c) {
        for (int i = 0; i < 5; i++) {
            visited[r + dr[i]][c + dc[i]] = false;
        }
    }

    private static int visit(int r, int c) {
        int res = 0;
        for (int i = 0; i < 5; i++) {
            visited[r + dr[i]][c + dc[i]] = true;
            res += board[r + dr[i]][c + dc[i]];
        }
        return res;
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        answer = Integer.MAX_VALUE;
        board = new int[N][N];
        visited = new boolean[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
