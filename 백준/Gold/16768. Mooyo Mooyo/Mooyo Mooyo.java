import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int r, c;
        public Node (int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int N, K;
    static char[][] board;
    static boolean[][] visited;
    static Deque<Node> dq, removeDq;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};
    public static void main(String[] args) throws Exception{
        init();
        solve();
    }

    private static void solve() {
        while (true) {
            if (dfs()) {
                down();
            } else {
                break;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    private static void down() {
        for (int i = 0; i < 10; i++) {
            char[] temp = new char[N];
            Arrays.fill(temp, '0');
            int idx = N;
            for (int j = N - 1; j >= 0; j--) {
                if (board[j][i] != '0') {
                    temp[--idx] = board[j][i];
                }
            }

            for (int j = 0; j < N; j++) {
                board[j][i] = temp[j];
            }
        }
    }

    private static boolean dfs() {
        removeDq = new ArrayDeque<>();
        visited = new boolean[N][10];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 10; j++) {
                if (!visited[i][j] && board[i][j] != '0') {
                    remove(i, j);
                }
            }
        }

        if (removeDq.isEmpty()) {
            return false;
        } else {
            while (!removeDq.isEmpty()) {
                Node cur = removeDq.poll();

                board[cur.r][cur.c] = '0';
            }
            return true;
        }
    }

    private static void remove(int r, int c) {
        dq = new ArrayDeque<>();
        Deque<Node> temp = new ArrayDeque<>();
        Node n = new Node(r, c);

        int cnt = 1;

        dq.add(n);
        temp.add(n);
        visited[r][c] = true;

        while (!dq.isEmpty()) {
            Node cur = dq.poll();

            for (int i = 0; i < 4; i++) {
                int newR = cur.r + dr[i];
                int newC = cur.c + dc[i];

                if (0 > newR || 0 > newC || N <= newR || 10 <= newC) continue;
                if (visited[newR][newC]) continue;

                if (board[r][c] == board[newR][newC]) {
                    dq.add(new Node(newR, newC));
                    temp.add(new Node(newR, newC));
                    visited[newR][newC] = true;
                    cnt++;
                }
            }
        }

        if (cnt >= K) {
            while (!temp.isEmpty()) {
                removeDq.add(temp.poll());
            }
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new char[N][10];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

    }
}
