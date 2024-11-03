import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static String[][] graph = new String[5][5];
    static Set<String> set = new HashSet<>();
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                graph[i][j] = st.nextToken();
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, 0, graph[i][j]);
            }
        }
//        System.out.println(set);
        System.out.println(set.size());
    }

    private static void dfs(int r, int c, int cnt, String s) {
        if (cnt == 5) {
            set.add(s);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int newR = r + dr[i];
            int newC = c + dc[i];

            if (newR < 0 || newR >= 5 || newC < 0 || newC >= 5) {
                continue;
            }
            dfs(newR, newC, cnt+1, s+graph[newR][newC]);
        }


    }
}
