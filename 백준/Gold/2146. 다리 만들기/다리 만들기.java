import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int islandNum;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};
    static int[][] board;
    static int[][] island;
    static int[][] dist;
    static int[][] copyDist;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception{
        init();
        solve();

        /**
         1. 이어진 섬에 번호를 붙인다. (2번부터)
         2. 끝쪽인 경우에는 q에 넣어준다.
         3. 다른 섬에 닿았을 때 거리를 갱신해준다.
         */
    }

    private static void solve() {
        islandNum = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && board[i][j] == 1) {
                    dfs(i, j);
                }
            }
        }

        Queue<Node2146>[] q = new Queue[islandNum+1];

        for (int i = 0; i < q.length; i++) {
            q[i] = new LinkedList<>();
        }
        dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 4; k++) {
                    int newR = i + dr[k];
                    int newC = j + dc[k];

                    if (0 > newR || newR >= N || 0 > newC || newC >= N) continue;

                    if (island[i][j] != 0 && island[newR][newC] == 0) {
                        q[island[i][j]].add(new Node2146(i, j));
                        dist[i][j] = 1;
                    }
                }
            }
        }

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < q.length; i++) {
            answer = Math.min(bfsBridge(i, q[i], dist), answer);
        }

        System.out.println(answer-1);
    }

    private static int bfsBridge(int islandId, Queue<Node2146> queue, int[][] baseDist) {
        int[][] copyDist = new int[N][N];
        for (int i = 0; i < N; i++) {
            copyDist[i] = Arrays.copyOf(baseDist[i], N);
        }

        while (!queue.isEmpty()) {
            Node2146 node = queue.poll();

            for (int d = 0; d < 4; d++) {
                int newR = node.r + dr[d];
                int newC = node.c + dc[d];

                if (0 > newR || newR >= N || 0 > newC || newC >= N) continue;

                if (island[newR][newC] != 0 && island[newR][newC] != islandId) {
                    return copyDist[node.r][node.c];
                }

                if (copyDist[newR][newC] != 0 || board[newR][newC] == 1) continue;

                queue.add(new Node2146(newR, newC));
                copyDist[newR][newC] = copyDist[node.r][node.c] + 1;
            }
        }

        return Integer.MAX_VALUE;
    }

    private static void dfs(int r, int c) {
        islandNum++;
        island[r][c] = islandNum;
        Queue<Node2146> queue = new LinkedList<>();
        queue.add(new Node2146(r, c));
        visited[r][c] = true;

        while(!queue.isEmpty()) {
            Node2146 node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int newR = node.r + dr[i];
                int newC = node.c + dc[i];
                
                if (rangeValidate(newR, newC)) {
                    continue;
                }

                queue.add(new Node2146(newR, newC));
                visited[newR][newC] = true;
                island[newR][newC] = islandNum;
            }
        }
    }

    private static boolean rangeValidate(int newR, int newC) {
        return 0 > newR || newR >= N || 0 > newC || newC >= N || visited[newR][newC] || board[newR][newC] == 0;
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        island = new int[N][N];
        visited = new boolean[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}

class Node2146 {
    int r, c, num;

    public Node2146(int r, int c) {
        this.r = r;
        this.c = c;
    }

    public Node2146(int r, int c, int num) {
        this.r = r;
        this.c = c;
        this.num = num;
    }
}