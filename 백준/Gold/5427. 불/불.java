import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int t, h, w;
    static boolean[][] visited;
    static char[][] arr;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};
    static Queue<Node> fire;
    static Queue<Node> q;
    static int cnt;
    static boolean canEscape;

    static class Node {
        int r, c;
        char v;
        Node (int r, int c, char v) {
            this.r = r;
            this.c = c;
            this.v = v;
        }
    }

    public static void main(String[] args) throws Exception{
        init();

        /**
         * 1. 불이 먼저 퍼진다.
         * 2. 상근이를 그 후에 옮긴다.
         */
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            arr = new char[h][w];
            visited = new boolean[h][w];
            cnt = 0;
            canEscape = false;
            fire = new LinkedList<>();
            q = new LinkedList<>();
            for (int r = 0; r < h; r++) {
                String temp = br.readLine();
                for (int c = 0; c < w; c++) {
                    arr[r][c] = temp.charAt(c);
                    if (arr[r][c] == '*') {
                        fire.add(new Node(r, c, '*'));
                        visited[r][c] = true;
                    } else if (arr[r][c] == '@') {
                        q.add(new Node(r, c, '@'));
                        visited[r][c] = true;
                    }
                }
            }

            bfs();

            if (canEscape) {
                System.out.println(cnt);
            } else {
                System.out.println("IMPOSSIBLE");
            }

        }
    }

    private static void bfs() {
        while (!q.isEmpty()) {
            cnt++;

            // 불이 먼저 퍼진다.
            int fireSize = fire.size();
            for (int i = 0; i < fireSize; i++) {
                Node f = fire.poll();

                for (int j = 0; j < 4; j++) {
                    int newR = f.r + dr[j];
                    int newC = f.c + dc[j];

                    if (newR < 0 || newC < 0 || newR >= h || newC >= w) continue;
                    if (arr[newR][newC] == '.' || arr[newR][newC] == '@') {
                        arr[newR][newC] = '*';
                        fire.add(new Node(newR, newC, '*'));
                    }
                }
            }

            // 상근이가 이동한다.
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                Node now = q.poll();

                for (int j = 0; j < 4; j++) {
                    int newR = now.r + dr[j];
                    int newC = now.c + dc[j];

                    // 범위를 벗어나면 탈출 가능
                    if (newR < 0 || newC < 0 || newR >= h || newC >= w) {
                        canEscape = true;
                        return;
                    }

                    if (arr[newR][newC] == '.' && !visited[newR][newC]) {
                        visited[newR][newC] = true;
                        q.add(new Node(newR, newC, '@'));
                    }
                }
            }
        }
    }

}
