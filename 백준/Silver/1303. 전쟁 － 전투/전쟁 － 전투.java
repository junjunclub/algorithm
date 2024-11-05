import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static boolean[][] visited;
    static char[][] list;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};
    static int n, m, b, w;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[m][n];
        list = new char[m][n];

        for (int i = 0; i < m; i ++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                list[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    int temp = bfs(i, j, list[i][j]);
                    if (list[i][j] == 'W') {
                        w += (temp * temp);
                    } else {
                        b += (temp * temp);
                    }
                }
            }
        }
        sb.append(w).append(" ").append(b);

        System.out.println(sb);
    }

    private static int bfs(int r, int c, char ch) {
        int answer = 1;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(r, c));
        visited[r][c] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int i = 0; i < 4; i++) {
                int newR = node.r + dr[i];
                int newC = node.c + dc[i];

                if (0 > newR || newR >= m || 0 > newC || newC >= n || visited[newR][newC] || list[newR][newC] != ch) {
                    continue;
                }
                q.add(new Node(newR, newC));
                visited[newR][newC] = true;
                answer++;
            }
        }
        return answer;
    }
}

class Node {
    int r, c;

    public Node (int r, int c) {
        this.r = r;
        this.c = c;
    }
}