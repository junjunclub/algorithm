import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static int N, M, answer;
    static int[][] graph;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = 0;
        findBoomerang(0, 0);
        System.out.println(answer);
    }

    private static void findBoomerang(int idx, int sumV) {
        if (idx == N*M) {
            answer = Math.max(answer, sumV);
            return;
        }

        int r = idx / M; // 0보다 작아질 수 없음
        int c = idx % M; // 0보다 작아질 수 없음

        if (!visited[r][c]) {
            // ㄱ 모양
            if (r+1 < N && c-1 >= 0 && !visited[r+1][c] && !visited[r][c-1]) {
                visited[r+1][c] = true;
                visited[r][c] = true;
                visited[r][c-1] = true;
                findBoomerang(idx+1, sumV + (graph[r][c] * 2) + graph[r+1][c] + graph[r][c-1]);
                visited[r+1][c] = false;
                visited[r][c] = false;
                visited[r][c-1] = false;
            }
            // ㄴ 모양
            if (r-1 >= 0 && c+1 < M && !visited[r-1][c] && !visited[r][c+1]) {
                visited[r-1][c] = true;
                visited[r][c] = true;
                visited[r][c+1] = true;
                findBoomerang(idx+1, sumV + (graph[r][c] * 2) + graph[r-1][c] + graph[r][c+1]);
                visited[r-1][c] = false;
                visited[r][c] = false;
                visited[r][c+1] = false;
            }
            // ㄱ 반대모양
            if (r+1 < N && c+1 < M && !visited[r+1][c] && !visited[r][c+1]) {
                visited[r+1][c] = true;
                visited[r][c] = true;
                visited[r][c+1] = true;
                findBoomerang(idx+1, sumV + (graph[r][c] * 2) + graph[r+1][c] + graph[r][c+1]);
                visited[r+1][c] = false;
                visited[r][c] = false;
                visited[r][c+1] = false;
            }
            // ㄴ 반대모양
            if (r-1 >= 0 && c-1 >= 0 && !visited[r-1][c] && !visited[r][c-1]) {
                visited[r-1][c] = true;
                visited[r][c] = true;
                visited[r][c-1] = true;
                findBoomerang(idx+1, sumV + (graph[r][c] * 2) + graph[r-1][c] + graph[r][c-1]);
                visited[r-1][c] = false;
                visited[r][c] = false;
                visited[r][c-1] = false;
            }
        }
        findBoomerang(idx+1, sumV);
    }
}
