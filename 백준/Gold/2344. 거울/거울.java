import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int r, c, d;
        public Node (int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }
    static int N, M, dir;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[][] board;
    static List<Node> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
            init();
            solve();
        }

    private static void solve() {
//        for (int i = 0; i <= N + 1; i++) {
//            for (int j = 0; j <= M + 1; j++) {
//                System.out.print(board[i][j]);
//                System.out.print(" ");
//            }
//            System.out.println();
//        }

        for (int i = 0; i < list.size(); i++) {
            move(list.get(i));
        }

        System.out.println(sb);
    }

    private static void move(Node node) {
        int d = node.d;
        int x = node.r;
        int y = node.c;
        while (true) {
            int newR = x + dr[d];
            int newC = y + dc[d];

            if (board[newR][newC] > 0) {
                sb.append(board[newR][newC]).append(" ");
                break;
            }

            if (board[newR][newC] == -1) {
                if (d == 0) d = 3;     // down → right
                else if (d == 1) d = 2; // right → up
                else if (d == 2) d = 1; // up → left
                else if (d == 3) d = 0; // left → down
            }

            x = newR;
            y = newC;
        }
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N + 2][M + 2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken()) * (-1);
            }
        }
        dir = -1;
        int num = 1;
        int x = 0;
        int y = 0;
        while (num <= (N + M) * 2) {
            if ((x == 0 && y == 0) || (x == 0 && y == M + 1) || (x == N + 1 && y == 0) || (x == N + 1 && y == M + 1)) {
                dir++;
                x += dr[dir];
                y += dc[dir];
                continue;
            }
            board[x][y] = num;
            list.add(new Node(x, y, (dir + 1) % 4));
            x += dr[dir];
            y += dc[dir];
            num++;
        }
    }
}
