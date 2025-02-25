import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer>[] list, tree;
    static int[] parent, size;
    static int n, r, q;
    static BufferedReader br;

    public static void main(String[] args) throws Exception{
        init();
        solve();
    }

    private static void solve() throws IOException {
        makeTree(r, -1);
        countSubTreeNodes(r);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < q; i++) {
            int num = Integer.parseInt(br.readLine());

            sb.append(size[num]).append("\n");
        }
        System.out.println(sb);
    }

    private static void countSubTreeNodes(int nowNode) {
        size[nowNode] = 1;

        for (int node : tree[nowNode]) {
            countSubTreeNodes(node);
            size[nowNode] += size[node];
        }
    }

    private static void makeTree(int nowNode, int p) {
        for (int node : list[nowNode]) {
            if (node != p) {
                parent[node] = nowNode;
                tree[nowNode].add(node);
                makeTree(node, nowNode);
            }
        }
    }

    private static void init() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        tree = new ArrayList[n+1];

        parent = new int[n+1];
        size = new int[n+1];

        for (int i = 0; i < n+1; i++) {
            list[i] = new ArrayList<>();
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list[u].add(v);
            list[v].add(u);
        }
    }
}
