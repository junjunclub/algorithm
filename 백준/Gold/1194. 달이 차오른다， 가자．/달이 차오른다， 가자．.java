import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static char[][] board;
    static Queue<Node> q;
    static boolean[][][] visited;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};
    static int r, c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        board = new char[r][c];
        q = new LinkedList<>();
        visited = new boolean[64][r][c];

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0 ; j< c; j++) {
                board[i][j] = str.charAt(j);
                if (board[i][j] == '0') {
                    q.add(new Node(i, j, 0, 0));
                    visited[0][i][j] = true;
                }
            }
        }

        /**
         * 되돌아가는걸 어떻게 처리하지?
         * "visited를 3차원으로 처리" -> 힌트 참고함
         */

        int answer = bfs();
        System.out.println(answer);
    }

    private static int bfs() {
        while (!q.isEmpty()) {
            Node node = q.poll();
            int cR = node.r;
            int cC = node.c;
            int cCost = node.cost;
            int cK = node.key;

            if (board[cR][cC] == '1') {
                return cCost;
            }

            for (int i = 0; i < 4; i++) {
                int newR = cR + dr[i];
                int newC = cC + dc[i];

                if (0 > newR || newR >= r || 0 > newC || newC >= c || visited[cK][newR][newC] || board[newR][newC] == '#') continue;

                // 문을 만났을 때
                if (board[newR][newC] >= 'A' && board[newR][newC] <= 'F') {
                    int door = 1 << (board[newR][newC] -'A');
                    if ((door & cK) > 0) {
                        visited[cK][newR][newC] = true;
                        q.add(new Node(newR, newC, cCost + 1, cK));
                    }
                }
                // 열쇠를 만났을 때
                else if (board[newR][newC] >= 'a' && board[newR][newC] <= 'f') {
                    int newK = 1 << (board[newR][newC] - 'a');
                    newK = newK | cK;
                    q.add(new Node(newR, newC, cCost + 1, newK));
                    visited[newK][newR][newC] = true;
                    visited[cK][newR][newC] = true;
                }

                else if (board[newR][newC] == '.' || board[newR][newC] == '0' || board[newR][newC] == '1') {
                    q.add(new Node(newR, newC, cCost + 1, cK));
                    visited[cK][newR][newC] = true;
                }
            }
        }
        return -1;
    }
}

class Node {
    int r, c, cost, key;
    public Node (int r, int c, int cost, int key) {
        this.r = r;
        this.c = c;
        this.cost = cost;
        this.key = key;
    }
}
