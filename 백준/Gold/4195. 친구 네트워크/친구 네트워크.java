import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static Map<String, Integer> map;
    static int[] parent, size;
    public static void main(String[] args) throws Exception{
        init();
        solve();
    }

    private static void solve() {

    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int F = Integer.parseInt(br.readLine());
            map = new HashMap<>();
            parent = new int[F * 2];
            size = new int[F * 2];

            for (int j = 0; j < parent.length; j++) {
                parent[j] = j;
            }

            int idx = 0;
            for (int j = 0; j < F; j++) {
                st = new StringTokenizer(br.readLine());
                String first = st.nextToken();
                String second = st.nextToken();

                if (!map.containsKey(first)) {
                    map.put(first, idx);
                    parent[idx] = idx;
                    size[idx] = 1;
                    idx++;
                }

                if (!map.containsKey(second)) {
                    map.put(second, idx);
                    parent[idx] = idx;
                    size[idx] = 1;
                    idx++;
                }

                int result = union(map.get(first), map.get(second));
                System.out.println(result);
            }
        }
    }

    private static int union(int num1, int num2) {
        int root1 = find(num1);
        int root2 = find(num2);

        if (root1 != root2) {
            parent[root2] = root1;
            size[root1] += size[root2];
        }

        return size[find(root1)];
    }

    private static int find(int num) {
        if (parent[num] != num) {
            parent[num] = find(parent[num]);
        }
        return parent[num];
    }
}
