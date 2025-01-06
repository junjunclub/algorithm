import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static int[] dr = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dc = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    static int[][] sky;
    static Queue<Cloud> clouds = new LinkedList<>();
    static boolean[][] visited;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        sky = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                sky[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clouds.add(new Cloud(n-1, 0));
        clouds.add(new Cloud(n-2, 0));
        clouds.add(new Cloud(n-1, 1));
        clouds.add(new Cloud(n-2, 1));


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());

            moveCloud(d, count);
            addWater();
            makeNewCloud();
        }

        int sumV = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sumV += sky[i][j];
            }
        }

        System.out.println(sumV);
    }

    private static void moveCloud(int d, int count) {
        for (Cloud c : clouds) {
            c.r = (c.r + (count * dr[d])) % n;
            c.c = (c.c + (count * dc[d])) % n;

            if (c.r < 0) c.r += n;
            if (c.c < 0) c.c += n;

            sky[c.r][c.c] += 1;
            visited[c.r][c.c] = true;
        }
    }

    private static void addWater() {
        while (!clouds.isEmpty()) {
            Cloud cloud = clouds.poll();
            int cr = cloud.r;
            int cc = cloud.c;
            visited[cr][cc] = true;
            int cnt = 0;
            for (int i = 2; i <= 8; i+=2) {
                int newR = cr + dr[i];
                int newC = cc + dc[i];

                if (0 <= newR && newR < n && 0 <= newC && newC < n && sky[newR][newC] >= 1) {
                    cnt++;
                }
            }
            sky[cr][cc] += cnt;
        }
    }

    private static void makeNewCloud() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && sky[i][j] >= 2) {
                    sky[i][j] -= 2;
                    clouds.add(new Cloud(i, j));
                }
            }
        }

        visited = new boolean[n][n];
    }
}

class Cloud {
    int r, c;

    public Cloud (int r, int c) {
        this.r = r;
        this.c = c;
    }
}
