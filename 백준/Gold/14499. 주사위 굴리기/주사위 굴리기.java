import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    //      상 하 좌 우 앞 뒤
    // 동쪽  좌 우 하 상 앞 뒤
    // 서쪽  우 좌 상 하 앞 뒤
    // 남쪽  뒤 앞 좌 우 상 하
    // 북쪽  앞 뒤 좌 우 하 상

    // 동쪽이면 0 1 2 3 -> 2 3 1 0
    // 서쪽이면 0 1 2 3 -> 3 2 0 1
    // 남쪽이면 0 1 4 5 -> 5 4 0 1
    // 북쪽이면 0 1 4 5 -> 4 5 1 0

    static int N, M, x, y, K;
    static int[][] board;
    static int[] list;
    static StringBuilder sb;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};

    static int up = 0;
    static int down = 0;
    static int left = 0;
    static int right = 0;
    static int front = 0;
    static int back = 0;


    public static void main(String[] args) throws Exception{
        init();
        solve();
        System.out.println(sb);
    }

    private static void solve() {
        for (int i = 0; i < list.length; i++) {
            roll(x, y, list[i]-1);
        }
    }

    private static void roll(int r, int c, int n) {
        int newR = r + dr[n];
        int newC = c + dc[n];

        if (0 > newR || newR >= N || 0 > newC || newC >= M) return;

        // 동쪽
        if (n == 0) {
            int temp = up;
            up = left;
            left = down;
            down = right;
            right = temp;
        } else if (n == 1) {
            // 서쪽
            int temp = up;
            up = right;
            right = down;
            down = left;
            left = temp;
        } else if (n == 2) {
            // 북쪽
            int temp = up;
            up = front;
            front = down;
            down = back;
            back = temp;
        } else if (n == 3) {
            // 남쪽
            int temp = up;
            up = back;
            back = down;
            down = front;
            front = temp;
        }

        if (board[newR][newC] == 0) {
            board[newR][newC] = down;
        } else {
            down = board[newR][newC];
            board[newR][newC] = 0;
        }
        sb.append(up).append("\n");
        x = newR;
        y = newC;
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        list = new int[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
    }
}
