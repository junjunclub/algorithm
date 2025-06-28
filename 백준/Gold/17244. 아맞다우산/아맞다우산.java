import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.LinkedList;

public class Main {
    static int N, M;
    static char[][] board;
    static boolean[][][] seen;
    static int startR, startC, endR, endC;
    static int cnt;
    static int[][] itemIdx;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception {
        init();
        solve();
        /**
        1. 비트마스킹으로 챙긴 물건 체크
        */
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        List<int[]> items = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = line.charAt(j);
                board[i][j] = c;
                if (c == 'S') {
                    startR = i; startC = j;
                } else if (c == 'E') {
                    endR = i; endC = j;
                } else if (c == 'X') {
                    items.add(new int[]{i, j});
                }
            }
        }


        cnt = items.size();
        itemIdx = new int[N][M];
        for (int k = 0; k < cnt; k++) {
            int[] p = items.get(k);
            itemIdx[p[0]][p[1]] = k;
        }
        seen = new boolean[1 << cnt][N][M];
    }

    private static void solve() {
        bfs();
    }

    private static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(startR, startC, 0, 0));
        seen[0][startR][startC] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];
                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                char c = board[nr][nc];
                if (c == '#') continue;

                int nextMask = cur.mask;
                if (c == 'X') {
                    nextMask |= 1 << itemIdx[nr][nc];
                }

                if (seen[nextMask][nr][nc]) continue;
                seen[nextMask][nr][nc] = true;

                int ndist = cur.dist + 1;
                if (nr == endR && nc == endC && nextMask == (1 << cnt) - 1) {
                    System.out.println(ndist);
                    return;
                }
                q.add(new Node(nr, nc, nextMask, ndist));
            }
        }
    }

    static class Node {
        int r, c, mask, dist;
        Node(int r, int c, int mask, int dist) {
            this.r = r; this.c = c; this.mask = mask; this.dist = dist;
        }
    }
}