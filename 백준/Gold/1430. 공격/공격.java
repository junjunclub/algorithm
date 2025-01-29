import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static boolean[] visited;
    static int n;
    static double r, d, x, y;
    static List<Node1430> towers;
    static Queue<Node1430> q;
    static double answer = 0;
    public static void main(String[] args) throws IOException {
        init();
        solve();

        /**
         * 1. BFS 방식, q의 첫번째는 적의 좌표를 넣어준다.
         * 2. 거리를 검증해서 범위 안의 타워를 넣어준다.
         * 3. 타워에서 또 bfs를 돌려서, 해당하는 타워에 q 넣고 answer 넣어주기.
         */
    }

    private static void solve() {
        q = new LinkedList<>();
        q.add(new Node1430(x, y, 0));

        while (!q.isEmpty()) {
            Node1430 node = q.poll();
            double nR = node.r;
            double nC = node.c;
            int nDepth = node.depth;

            for (int i = 0; i < towers.size(); i++) {
                if (validate(nR, nC, i)) {
                    q.add(new Node1430(towers.get(i).r, towers.get(i).c, nDepth + 1));
                    visited[i] = true;
                }
            }

            if (nDepth != 0) {
                answer += d * (Math.pow(0.5, nDepth-1));
            }
        }
        System.out.println(answer);
    }

    private static boolean validate(double nR, double nC, int num) {
        Node1430 node = towers.get(num);

        double nodeR = node.r;
        double nodeC = node.c;
        return Math.sqrt(Math.pow(nR - nodeR, 2) + Math.pow(nC - nodeC, 2)) <= r && !visited[num];
    }

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        r = Double.parseDouble(st.nextToken());
        d = Double.parseDouble(st.nextToken());
        x = Double.parseDouble(st.nextToken());
        y = Double.parseDouble(st.nextToken());

        visited = new boolean[n];
        towers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            double x1 = Double.parseDouble(st.nextToken());
            double y1 = Double.parseDouble(st.nextToken());
            towers.add(new Node1430(x1, y1, 0));
        }
    }
}

class Node1430 {
    double r, c;
    int depth;
    public Node1430 (double r, double c, int depth) {
        this.r = r;
        this.c = c;
        this.depth = depth;
    }
}