import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K, ans;
    static int[][] board;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
            init();
            solve();
        /**
         * 다익스트라가 아니라 플로이드 워셜임...
         * 처음 배열들을 최솟값으로 갱신해주고, dfs 돌리기
         */
    }

    private static void solve() {
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    board[i][j] = Math.min(board[i][j], board[i][k] + board[k][j]);
                }
            }
        }
//
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                System.out.print(board[i][j]);
//                System.out.print(" ");
//            }
//            System.out.println();
//        }

        visited = new boolean[N];
        visited[K] = true;
        dfs(K, 0, 0);

        System.out.println(ans);
    }

    private static void dfs(int start, int depth, int sumV) {
        if (depth == N - 1) {
            ans = Math.min(ans, sumV);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, depth + 1, sumV + board[start][i]);
                visited[i] = false;
            }
        }
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new int[N][N];
        ans = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num;
            }
        }
    }
}