import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static List<Integer>[] list;
    static int[] arr;
    static Deque<Integer> q;
    public static void main(String[] args) throws Exception{
        init();
        solve();
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        arr = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            list[s].add(e);
            arr[e]++;
        }
    }

    private static void solve() {
        StringBuilder sb = new StringBuilder();
        q = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            if (arr[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();

            sb.append(cur).append(" ");

            for (Integer n : list[cur]) {
                arr[n]--;

                if (arr[n] == 0) {
                    q.add(n);
                }
            }
        }

        System.out.println(sb);
    }
}
