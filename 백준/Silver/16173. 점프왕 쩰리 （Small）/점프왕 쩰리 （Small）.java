import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static boolean answer = false;
    static int[][] arr;
    static int n;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();

        if (answer) {
            System.out.println("HaruHaru");
        } else {
            System.out.println("Hing");
        }
    }

    private static void bfs() {
        Queue<Jelly> q = new LinkedList<>();
        q.add(new Jelly(0, 0, arr[0][0]));
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Jelly jelly = q.poll();
            int vr = jelly.r;
            int vc = jelly.c;
            int vv = jelly.v;

            if (vv == -1) {
                answer = true;
            }

            for (int i = 0; i < 4; i++) {
                int newR = vr + (dr[i] * vv);
                int newC = vc + (dc[i] * vv);

                if (0 <= newR && newR < n && 0 <= newC && newC < n && !visited[newR][newC]) {
                    q.add(new Jelly(newR, newC, arr[newR][newC]));
                    visited[newR][newC] = true;
                }
            }
        }
    }

    static class Jelly {
        int r, c, v;
        public Jelly (int r, int c, int v) {
            this.r = r;
            this.c = c;
            this.v = v;
        }
    }
}
