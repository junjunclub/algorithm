import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
            init();
            solve();
        }

    private static void solve() {
        System.out.println(sb);
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String s1 = st.nextToken();
            String s2 = st.nextToken();
            String s3 = st.nextToken();

            if (bfs(s1, s2, s3)) {
                sb.append("Data set "+(i + 1)+": "+"yes").append("\n");
            } else {
                sb.append("Data set "+(i + 1)+": "+"no").append("\n");
            }
        }
    }

    private static boolean bfs(String s1, String s2, String s3) {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0, 0});

        boolean[][] visited = new boolean[201][201];

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int idx1 = cur[0];
            int idx2 = cur[1];
            int idx3 = cur[2];

            if (idx1 + idx2 == s3.length()) return true;

            if (idx1 < s1.length() && s1.charAt(idx1) == s3.charAt(idx3) && !visited[idx1 + 1][idx2]) {
                q.add(new int[]{idx1 + 1, idx2, idx3 + 1});
                visited[idx1 + 1][idx2] = true;
            }

            if (idx2 < s2.length() && s2.charAt(idx2) == s3.charAt(idx3) && !visited[idx1][idx2 + 1]) {
                q.add(new int[]{idx1, idx2 + 1, idx3 + 1});
                visited[idx1][idx2 + 1] = true;
            }
        }

        return false;
    }
}
