import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int x, y;
        public Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N;
    static Node[] arr;
    public static void main(String[] args) throws Exception{
            init();
            solve();
        }

    private static void solve() {
        int total = 0;

        for (int i = 1; i < N; i++) {
            total += calculate(arr[i], arr[i - 1]);
        }

        int maxV = 0;

        for (int i = 1; i < N - 1; i++) {
            int notSkipDist = calculate(arr[i], arr[i - 1]) + calculate(arr[i + 1], arr[i]);
            int skipDist = calculate(arr[i + 1], arr[i - 1]);

            maxV = Math.max(maxV, notSkipDist - skipDist);
        }

        System.out.println(total - maxV);
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new Node[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Node n = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            arr[i] = n;
        }
    }

    private static int calculate(Node n1, Node n2) {
        return Math.abs(n1.x - n2.x) + Math.abs(n1.y - n2.y);
    }
}
