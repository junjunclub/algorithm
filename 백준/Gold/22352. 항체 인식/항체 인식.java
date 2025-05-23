import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.LinkedList;

public class Main {
    static int N, M;
    static int[][] board1, board2;
    static boolean[][] visited;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};
    static int cnt = 0;
    public static void main(String[] args) throws Exception{
            init();
            solve();
        /**
         1. board1, board2 비교 시작
         2. 값이 다른 공간이 발견되면 bfs 메서드 실행
         3. bfs는 2회 이상 순회할 수 없음
         */
    }

    private static void solve() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board1[i][j] != board2[i][j] && !visited[i][j]) {
                    bfs(i, j);
                }

                if (cnt >= 2) {
                    break;
                }
            }
        }

        if (cnt < 2  && check()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static void print(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    private static boolean check() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board2[i][j] != board1[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void bfs(int r, int c) {
        Queue<Node22352> q = new LinkedList<>();
        q.add(new Node22352(r, c));
        visited[r][c] = true;
        int v = board2[r][c];
        int originV = board1[r][c];
        board1[r][c] = v;

        while (!q.isEmpty()) {
            Node22352 node = q.poll();

            for (int i = 0; i < 4; i++) {
                int newR = node.r + dr[i];
                int newC = node.c + dc[i];

                if (0 > newR || N <= newR || 0 > newC || M <= newC) continue;

                if (originV != board1[newR][newC]) {
                    continue;
                }

                if (visited[newR][newC]) {
                    continue;
                }

                q.add(new Node22352(newR, newC));
                visited[newR][newC] = true;
                board1[newR][newC] = v;
            }
        }

        cnt++;
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board1 = new int[N][M];
        board2 = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board1[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board2[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}

class Node22352 {
    int r, c;
    public Node22352 (int r, int c) {
        this.r = r;
        this.c = c;
    }
}