import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static char[][] board;
    static int[][][] visited;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0 , 0};
    public static void main(String[] args) throws Exception{
        init();
        solve();

        /**
         * 3차원 배열
         */
    }

    private static void solve() {
        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Node14442> q = new LinkedList<>();
        visited[0][0][0] = 1;
        q.add(new Node14442(0, 0, 0));

        while (!q.isEmpty()) {
            Node14442 cur = q.poll();

            int curR = cur.r;
            int curC = cur.c;
            int curZ = cur.z;

            if (curR == N - 1 && curC == M - 1) {
                return visited[curR][curC][curZ];
            }


            for (int i = 0; i < 4; i++) {
                int newR = curR + dr[i];
                int newC = curC + dc[i];

                if (0 > newR || newR >= N || 0 > newC || newC >= M ) continue;

                if (board[newR][newC] == '1') {
                    // 벽이고, 아직 K번 이하로 벽을 부쉈다면
                    if (curZ < K && visited[newR][newC][curZ + 1] == 0) {
                        q.add(new Node14442(newR, newC, curZ + 1));
                        visited[newR][newC][curZ + 1] = visited[curR][curC][curZ] + 1;
                    }
                } else if (board[newR][newC] == '0') {
                    if (visited[newR][newC][curZ] == 0) {
                        q.add(new Node14442(newR, newC, curZ));
                        visited[newR][newC][curZ] = visited[curR][curC][curZ] + 1;
                    }
                }

            }
        }
        return -1;
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        visited = new int[N][M][K+1];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }
    }
}

class Node14442 {
    int r, c, z;

    public Node14442(int r, int c, int z) {
        this.r = r;
        this.c = c;
        this.z = z;
    }
}