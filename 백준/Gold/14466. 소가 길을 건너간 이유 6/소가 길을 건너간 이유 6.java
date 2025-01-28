import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static ArrayList<Node14466>[][] roads;
    static boolean[][] visited;
    static List<Node14466> cows;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};
    static int n, k, r, answer;
    public static void main(String[] args) throws IOException {
        init();
        solve();

        /**
         * 1. 길을 Array에 양방향으로 넣어준다.
         * 2. 소를 기준점으로 길이 없는 곳에 bfs를 돌린다.
         */
    }

    private static void solve() {
        for (int i = 0; i < k; i++) {
            bfs(i);
        }

        System.out.println(answer / 2);
    }

    private static void bfs(int i) {
        visited = new boolean[n][n];
        Queue<Node14466> q = new LinkedList<>();
        q.add(new Node14466(cows.get(i).r, cows.get(i).c));
        visited[cows.get(i).r][cows.get(i).c] = true;

        while (!q.isEmpty()) {
            Node14466 node = q.poll();
            int r = node.r;
            int c = node.c;

            for (int j = 0; j < 4; j++) {
                int newR = r + dr[j];
                int newC = c + dc[j];
                boolean flag = false;

                if (0 > newR || newR >= n || 0 > newC || newC >= n || visited[newR][newC]) continue;

                for (int k = 0; k < roads[r][c].size(); k++) {
                    if (newR == roads[r][c].get(k).r && newC == roads[r][c].get(k).c) {
                        flag = true;
                        break;
                    }
                }

                if (flag) continue;

                visited[newR][newC] = true;
                q.add(new Node14466(newR, newC));
            }
        }

        for (int j = 0; j < k; j++) {
            int cowR = cows.get(j).r;
            int cowC = cows.get(j).c;

            if (!visited[cowR][cowC]) answer++;
        }
    }

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        roads = new ArrayList[n][n];
        cows = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                roads[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken()) - 1;
            int c1 = Integer.parseInt(st.nextToken()) - 1;
            int r2 = Integer.parseInt(st.nextToken()) - 1;
            int c2 = Integer.parseInt(st.nextToken()) - 1;

            roads[r1][c1].add(new Node14466(r2, c2));
            roads[r2][c2].add(new Node14466(r1, c1));
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int cr = Integer.parseInt(st.nextToken()) - 1;
            int cc = Integer.parseInt(st.nextToken()) - 1;

            cows.add(new Node14466(cr, cc));
        }

        answer = 0;
    }
}

class Node14466 {
    int r, c;
    public Node14466 (int r, int c) {
        this.r = r;
        this.c = c;
    }
}
