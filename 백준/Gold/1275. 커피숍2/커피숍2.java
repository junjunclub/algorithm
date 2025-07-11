import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, Q;
    static int[] list;
    static long[] tree;
    public static void main(String[] args) throws Exception{
        init();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        list = new int[N + 1];
        tree = new long[N * 4];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        treeInit(1, N, 1);

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (x > y) {
                int temp = y;
                y = x;
                x = temp;
            }

            sb.append(sum(1, N, 1, x, y)).append("\n");
            update(1, N, 1, a, b);
        }
        System.out.println(sb);
    }

    private static long update(int start, int end, int node, int idx, int val) {
        if (idx < start || idx > end) {
            return tree[node];
        }

        if (start == end) {
            return tree[node] = val;
        }

        int mid = (start + end) / 2;
        return tree[node] = update(start, mid, node * 2, idx, val) + update(mid + 1, end, node * 2 + 1, idx, val);
    }

    private static long sum(int start, int end, int node, int left, int right) {
        if (end < left || start > right) {
            return 0;
        }

        if (left <= start && end <= right) {
            return tree[node];
        }

        int mid = (start + end) / 2;
        return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
    }

    private static long treeInit(int start, int end, int node) {
        if (start == end) {
            return tree[node] = list[start];
        }

        int mid = (start + end) / 2;
        return tree[node] = treeInit(start, mid, node * 2) + treeInit(mid + 1, end, node * 2 + 1);
    }


}
