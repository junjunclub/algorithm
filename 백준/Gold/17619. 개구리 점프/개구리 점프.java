import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, Q;
    static int[] parents;

    static class Tree implements Comparable<Tree>{
        int x1, x2, y, idx;
        public Tree (int x1, int x2, int y, int idx) {
            this.x1 = x1;
            this.x2 = x2;
            this.y = y;
            this.idx = idx;
        }
        @Override
        public int compareTo (Tree t) {
            return Integer.compare(this.x1, t.x1);
        }
    }

    public static void main(String[] args) throws Exception{
            init();
        }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        parents = new int[N];

        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }

        Tree[] trees = new Tree[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            Tree t = new Tree(x1, x2, y, i);
            trees[i] = t;
        }

        Arrays.sort(trees);

        int start = trees[0].x1;
        int end = trees[0].x2;
        int idx = trees[0].idx;

        for (int i = 1; i < N; i++) {
            if (start <= trees[i].x1 && trees[i].x1 <= end) {
                union(idx, trees[i].idx);

                if (trees[i].x2 > end) {
                    end = trees[i].x2;
                }
            } else {
                start = trees[i].x1;
                end = trees[i].x2;
            }
            idx = trees[i].idx;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            if (find(s) == find(e)) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px == py) return;
        parents[py] = px;
    }

    private static int find(int x) {
        if (x != parents[x]) {
            parents[x] = find(parents[x]);
        }
        return parents[x];
    }
}
