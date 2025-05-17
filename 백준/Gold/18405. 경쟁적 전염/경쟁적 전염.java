import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K, S, X, Y;
    static int[][] board;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};
    static Queue<Node18405> q = new PriorityQueue<>();
    static Queue<Node18405> q2 = new PriorityQueue<>();
    public static void main(String[] args) throws Exception{
            init();
            solve();
        }

    private static void solve() {
        bfs();
        System.out.println(board[X][Y]);
    }

    private static void bfs() {
        int time = 0;

        while (true) {
            if (time == S) return;

            while (!q.isEmpty()) {
                Node18405 now = q.poll();
                for (int i = 0; i < 4; i++) {
                    int newR = now.r + dr[i];
                    int newC = now.c + dc[i];

                    if (0 > newR || N <= newR || 0 > newC || N <= newC || board[newR][newC] != 0) continue;

                    q2.add(new Node18405(newR, newC, now.v));
                    board[newR][newC] = now.v;
                }

            }

            while (!q2.isEmpty()) {
                q.add(q2.poll());
            }
            time++;
        }

    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num != 0) {
                    board[i][j] = num;
                    q.add(new Node18405(i, j, num));
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken()) - 1;
        Y = Integer.parseInt(st.nextToken()) - 1;
    }
}

class Node18405 implements Comparable<Node18405>{
    int r, c, v;
    public Node18405 (int r, int c, int v) {
        this.r = r;
        this.c = c;
        this.v = v;
    }
    @Override
    public int compareTo(Node18405 n) {
        return Integer.compare(this.v, n.v);
    }
}
