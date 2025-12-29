import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static StringBuilder sb = new StringBuilder();
    static Map<Integer, Integer> map;
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

        map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            if (a == 1) {
                int v = Integer.parseInt(st.nextToken());
                int key = Integer.parseInt(st.nextToken());

                map.put(key, v);
            } else {
                int key = Integer.parseInt(st.nextToken());
                sb.append(map.get(key)).append("\n");
            }
        }
    }
}
