import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.LinkedList;

public class Main {
    static int N;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int[] answer;
    static Queue<Integer> q;
    public static void main(String[] args) throws Exception{
            init();
            solve();
        }

    private static void solve() {
        bfs();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }

    private static void bfs() {
        while (!q.isEmpty()) {
            int num = q.poll();

            for (int next : graph[num]) {
                if (answer[next] == -1) {
                    answer[next] = answer[num] + 1;
                    q.add(next);
                }
            }
        }
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        graph = new List[N + 1];
        q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            graph[s].add(e);
            graph[e].add(s);
        }

        answer = new int[N + 1];
        Arrays.fill(answer, -1);

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            cycleCheck(i, i, 1);
        }
    }

    private static void cycleCheck(int now, int start, int cnt) {
        visited[now] = true;

        for (int next: graph[now]) {
            if (!visited[next]) {
                cycleCheck(next, start, cnt + 1);
            } else if (next == start && cnt >= 3) {
                answer[next] = 0;
                q.offer(next);
                return;
            }
        }
    }
}