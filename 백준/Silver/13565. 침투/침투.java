import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static int m;
    static int n;
    static int[][] graph;
    static boolean flag;
    static boolean[][] visited;
    static Queue<int[]> queue;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        graph = new int[m][n];
        visited = new boolean[m][n];
        queue = new LinkedList<>();
        flag = false;

        for (int i = 0; i < m; i++) {
            String temp = br.readLine();
            for (int j = 0; j < n; j++) {
                graph[i][j] = temp.charAt(j) - '0';
                if (i == 0 && graph[i][j] == 0) {
                    queue.add(new int[] {i, j});
                    visited[i][j] = true;
                }
            }
        }

        bfs();

        if (flag) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            int[] v = queue.poll();
            int vr = v[0];
            int vc = v[1];

            if (vr == m - 1) {
                flag = true;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int newR = vr + dx[i];
                int newC = vc + dy[i];

                if (0 > newR || newR >= m || 0 > newC || newC >= n || visited[newR][newC] || graph[newR][newC] == 1) {
                    continue;
                }

                queue.add(new int[] {newR, newC});
                visited[newR][newC] = true;
            }
        }
    }
}