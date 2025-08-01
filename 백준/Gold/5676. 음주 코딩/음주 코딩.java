import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static StringBuilder sb = new StringBuilder();
    static long[] tree;
    static int[] arr;
    public static void main(String[] args) throws Exception{
            init();
            solve();
        }

    private static void solve() {

    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String input;

        while ((input = br.readLine()) != null) {
            st = new StringTokenizer(input);

            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            arr = new int[N + 1];
            tree = new long[N * 4];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            init(1, N, 1);

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());

                String command = st.nextToken();
                int num1 = Integer.parseInt(st.nextToken());
                int num2 = Integer.parseInt(st.nextToken());

                if (command.equals("C")) {
                    update(1, N, 1, num1, num2);
                } else {
                    long temp = multiple(1, N, 1, num1, num2);

                    if (temp > 0) {
                        sb.append("+");
                    } else if (temp < 0) {
                        sb.append("-");
                    } else {
                        sb.append("0");
                    }
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int sign (int x) {
        if (x > 0) return 1;
        else if (x < 0) return -1;
        return 0;
    }

    private static long update(int start, int end, int node, int idx, int value) {
        if (idx < start || idx > end) {
            return tree[node];
        }

        if (start == end) {
            return tree[node] = sign(value);
        }

        int mid = (start + end) / 2;

        return tree[node] = update(start, mid, node * 2, idx ,value) * update(mid + 1, end, node * 2 + 1, idx, value);
    }

    private static long multiple (int start, int end, int node, int left, int right) {
        if (end < left || start > right) {
            return 1;
        }

        if (left <= start && end <= right) {
            return tree[node];
        }

        int mid = (start + end) / 2;
        return multiple(start, mid, node * 2, left, right) * multiple(mid + 1, end, node * 2 + 1, left, right);
    }

    private static long init (int start, int end, int node) {
        if (start == end) {
            return tree[node] = sign(arr[start]);
        }

        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, node * 2) * init(mid + 1, end, node * 2  + 1);
    }
}
