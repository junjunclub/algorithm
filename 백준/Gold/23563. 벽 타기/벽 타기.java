import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int r, c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int H, W, sr, sc, er, ec;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};
    static char[][] board;
    static int[][] dist;
    static Deque<Node> dq = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        init();
        bfs();
        System.out.println(dist[er][ec]);
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        board = new char[H][W];
        dist = new int[H][W];

        for (int i = 0; i < H; i++) {
            String s = br.readLine();
            for (int j = 0; j < W; j++) {
                board[i][j] = s.charAt(j);
                dist[i][j] = Integer.MAX_VALUE;
                if (board[i][j] == 'S') {
                    sr = i; 
                    sc = j;
                } else if (board[i][j] == 'E') {
                    er = i; 
                    ec = j;
                }
            }
        }
    }

    private static void bfs() {
        dq.add(new Node(sr, sc));
        dist[sr][sc] = 0;

        while (!dq.isEmpty()) {
            Node cur = dq.poll();

            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if (nr < 0 || nr >= H || nc < 0 || nc >= W) continue;
                if (board[nr][nc] == '#') continue;

                int cost = nearByWall(cur.r, cur.c) && nearByWall(nr, nc) ? 0 : 1;

                if (dist[cur.r][cur.c] + cost < dist[nr][nc]) {
                    dist[nr][nc] = dist[cur.r][cur.c] + cost;
                    if (cost == 0) dq.addFirst(new Node(nr, nc));
                    else dq.addLast(new Node(nr, nc));
                }
            }
        }
    }

    private static boolean nearByWall(int r, int c) {
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr < 0 || nr >= H || nc < 0 || nc >= W) continue;
            if (board[nr][nc] == '#') return true;
        }
        return false;
    }
}
