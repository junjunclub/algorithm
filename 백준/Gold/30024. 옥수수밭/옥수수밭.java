import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static int cnt;
    static int[][] map;
    static boolean[][] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        PriorityQueue<Field> pq = new PriorityQueue<Field>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (i == 0 || j == 0 || i == n-1 || j == m-1) {
                    pq.add(new Field(i, j, map[i][j]));
                    visited[i][j] = true;
                }
            }
        }

        cnt = Integer.parseInt(br.readLine());

        bfs(n, m, pq);
        System.out.println(sb);
    }

    private static void bfs(int n, int m, PriorityQueue<Field> pq) {
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!pq.isEmpty()) {
            Field f = pq.poll();
            cnt --;
            sb.append(f.row+1).append(" ").append(f.col+1).append("\n");
            if (cnt == 0) {
                return;
            }

            int vr = f.row;
            int vc = f.col;

            for (int i = 0; i < 4; i++) {
                int newR = vr+dr[i];
                int newC = vc+dc[i];

                if (0 > newR || newR >= n || 0 > newC || newC >= m || visited[newR][newC]) {
                    continue;
                }

                visited[newR][newC] = true;
                pq.add(new Field(newR, newC, map[newR][newC]));
            }
        }
    }
}

class Field implements Comparable<Field> {
    int row;
    int col;
    int value;

    public Field(int row, int col, int value) {
        this.row = row;
        this.col = col;
        this.value = value;
    }

    @Override
    public int compareTo(Field o) {
        return o.value - this.value;
    }
}