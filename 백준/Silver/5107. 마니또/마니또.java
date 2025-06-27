import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, answer;
    static StringTokenizer st;
    static Map<String, Integer> map;
    static List<Integer>[] list;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
            init();
        }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = 1;
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            map = new HashMap<>();
            list = new List[N];
            answer = 0;
            visited = new boolean[N];
            for (int i = 0; i < N; i++) {
                list[i] = new ArrayList<>();
            }

            int idx = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                String p1 = st.nextToken();
                String p2 = st.nextToken();
                if (!map.containsKey(p1)) {
                    map.put(p1, idx);
                    idx++;
                }
                if (!map.containsKey(p2)) {
                    map.put(p2, idx);
                    idx++;
                }

                list[map.get(p1)].add(map.get(p2));
            }

            for (int i = 0; i < N; i++) {
                if (!visited[i]) {
                    dfs(i);
                }
            }

            sb.append(T).append(" ").append(answer).append("\n");
            T++;
        }
        System.out.println(sb);
    }

    private static void dfs(int n) {
        Stack<Integer> st = new Stack<>();
        st.add(n);
        visited[n] = true;
        boolean first = true;

        while (!st.isEmpty()) {
            Integer now = st.pop();

            if (!first && now == n) {
                answer++;
                return;
            }

            for (Integer next : list[now]) {
                st.add(next);
                visited[next] = true;
            }

            first = false;
        }
    }
}
