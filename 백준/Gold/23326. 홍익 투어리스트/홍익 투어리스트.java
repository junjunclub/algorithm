import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    static int N, Q, cur;

    static TreeSet<Integer> treeSet;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        init();
        System.out.println(sb);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        cur = 0;

        treeSet = new TreeSet<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            if (n == 1) treeSet.add(i);
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());

            if (command == 1) {
                int v = Integer.parseInt(st.nextToken()) - 1;
                query1(v);
            } else if (command == 2) {
                int v = Integer.parseInt(st.nextToken());
                query2(v);
            } else if (command == 3) {
                query3();
            }
        }
    }

    private static void query1(int v) {
        if (treeSet.contains(v)) {
            treeSet.remove(v);
        } else {
            treeSet.add(v);
        }
    }

    private static void query2(int v) {
        cur = (cur + v) % N;
    }

    private static void query3() {
        int ans = -1;
        Integer target = treeSet.ceiling(cur);

        if (target == null) {
            Integer startPointTarget = treeSet.ceiling(0);
            if (startPointTarget != null) {
                ans = N - cur + startPointTarget;
            }
        } else {
            ans = target - cur;
        }

        sb.append(ans).append("\n");
    }
}
