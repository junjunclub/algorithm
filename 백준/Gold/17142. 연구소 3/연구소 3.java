import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node {
        int r, c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int N, M, emptyCnt;
    static int[][] board;
    static List<Node> viruses = new ArrayList<>();
    static int[] path;
    static int minV = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    private static void solve() {
        comb(0, 0);
        System.out.println(minV == Integer.MAX_VALUE ? -1 : minV);
    }

    // 조합
    private static void comb(int idx, int depth) {
        if (depth == M) {
            minV = Math.min(minV, bfs(path));
            return;
        }

        for (int i = idx; i < viruses.size(); i++) {
            path[depth] = i;
            comb(i + 1, depth + 1);
        }
    }
    
    private static int bfs(int[] path) {
        int[][] dist = new int[N][N];
        for (int[] row : dist) Arrays.fill(row, -1);

        Deque<Node> q = new ArrayDeque<>();
        int infected = 0;
        int maxTime = 0;
        
        for (int i : path) {
            Node v = viruses.get(i);
            q.add(v);
            dist[v.r][v.c] = 0;
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                if (board[nr][nc] == 1) continue;

                if (dist[nr][nc] == -1) {
                    dist[nr][nc] = dist[cur.r][cur.c] + 1;
                    q.add(new Node(nr, nc));

                    if (board[nr][nc] == 0) {
                        infected++;
                        maxTime = Math.max(maxTime, dist[nr][nc]);
                        
                        if (infected == emptyCnt) return maxTime;
                    }
                }
            }
        }

        if (infected != emptyCnt) return Integer.MAX_VALUE;
        return maxTime;
    }

    
    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        path = new int[M];
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());

                if (board[i][j] == 2) {
                    viruses.add(new Node(i, j));
                } else if (board[i][j] == 0) {
                    emptyCnt++;
                }
            }
        }
    }
}
