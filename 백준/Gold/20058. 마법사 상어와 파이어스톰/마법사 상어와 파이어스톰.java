import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, Q;
    static int[][] board;
    static boolean[][] visited;
    static int[] list;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static int totalSize, totalSum, biggestV;
    public static void main(String[] args) throws Exception{
        init();
        solve();
    }

    private static void solve() {
        for (int i = 0; i < list.length; i++) {
            int size = list[i];

            // 배열 회전
            roll(size);
            // 회전 후 녹이기
            melt();
        }

        visited = new boolean[totalSize][totalSize];
        for (int i = 0; i < totalSize; i++) {
            for (int j = 0; j < totalSize; j++) {
                if (board[i][j] > 0) totalSum += board[i][j];

                if (!visited[i][j] && board[i][j] > 0) {
                    biggestV = Math.max(biggestV, dfs(i, j));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(totalSum).append("\n").append(biggestV);
        System.out.println(sb);
    }

    private static void melt() {
        int[][] newBoard = new int[totalSize][totalSize];

        for (int i = 0; i < totalSize; i++) {
            for (int j = 0; j < totalSize; j++) {
                int cnt = 0;
                for (int d = 0; d < 4; d++) {
                    int nr = i + dr[d];
                    int nc = j + dc[d];

                    if (nr >= 0 && nr < totalSize && nc >= 0 && nc < totalSize && board[nr][nc] > 0) {
                        cnt++;
                    }
                }

                // 얼음이 있는 경우만 감소
                if (board[i][j] > 0 && cnt < 3) {
                    newBoard[i][j] = board[i][j] - 1;
                } else {
                    newBoard[i][j] = board[i][j];
                }
            }
        }

        board = newBoard;
    }

    private static int dfs(int r, int c) {
        visited[r][c] = true;
        int cnt = 1;

        for (int i = 0; i < 4; i++) {
            int newR = r + dr[i];
            int newC = c + dc[i];

            if (newR >= 0 && newR < totalSize && newC >= 0 && newC < totalSize &&
                    !visited[newR][newC] && board[newR][newC] > 0) {
                cnt += dfs(newR, newC);
            }
        }

        return cnt;
    }

    private static void roll(int n) {
        totalSize = (int) Math.pow(2, N);
        int size = (int) Math.pow(2, n);

        int[][] temp = new int[totalSize][totalSize];

        for (int i = 0; i < totalSize; i += size) {
            for (int j = 0; j < totalSize; j += size) {
                for (int a = 0; a < size; a++) {
                    for (int b = 0; b < size; b++) {
                        temp[i+b][j+size-1-a] = board[i+a][j+b];
                    }
                }
            }
        }
        board = temp;
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        totalSize = (int) Math.pow(2, N);
        totalSum = 0;
        biggestV = 0;

        board = new int[totalSize][totalSize];

        for (int i = 0; i < totalSize; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < totalSize; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        list = new int[Q];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
    }
}
