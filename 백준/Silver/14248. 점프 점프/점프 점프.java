import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] stone;
    static Queue<Integer> q = new LinkedList<>();
    static boolean[] visited;
    static int answer;
    static int n;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        stone = new int[n];
        visited = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            stone[i] = Integer.parseInt(st.nextToken());
        }

        int start = Integer.parseInt(br.readLine());
        answer = bfs(start);

        System.out.println(answer);
    }

    private static int bfs(int start) {
        int cnt = 1;

        visited[start-1] = true;

        q.add(start-1);

        while (!q.isEmpty()) {
            int v = q.poll();

            int vm = v - stone[v];
            int vp = v + stone[v];

            if (0 <= vm && vm < n && !visited[vm]) {
                q.add(vm);
                visited[vm] = true;
                cnt++;
            }

            if (0 <= vp && vp < n && !visited[vp]) {
                q.add(vp);
                visited[vp] = true;
                cnt++;
            }
        }
        return cnt;
    }
}
