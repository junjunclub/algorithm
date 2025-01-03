import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int[][] answer;
    static char[][] list;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {-1, 1, 0, 0};
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new char[n][m];
        answer = new int[n][m];

        for (int[] row : answer) Arrays.fill(row, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            list[i] = br.readLine().toCharArray();
        }

        Queue<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (list[i][j] == '1') {
                    answer[i][j] = 0;
                    q.add(new int[] {i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int nr = node[0];
            int nc = node[1];
            int dist = answer[nr][nc];

            for (int i = 0; i < 4; i++) {
                int newR = nr + dr[i];
                int newC = nc + dc[i];

                if (newR<0 || newR>=n || newC<0 || newC>=m || answer[newR][newC] <= dist+1) continue;
                answer[newR][newC] = dist + 1;
                q.add(new int[] {newR, newC});
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}