import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int N, T, G, ans;

    static class Node {
        int number, cnt;

        public Node(int number, int cnt) {
            this.number = number;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws Exception{
        init();
        solve();
    }

    private static void solve() {
        ans = -1;
        bfs(N);

        if (ans == -1) {
            System.out.println("ANG");
        } else {
            System.out.println(ans);
        }
    }

    private static void bfs(int N) {
        Deque<Node> q = new ArrayDeque<>();
        boolean[] visited = new boolean[100000];

        Node first = new Node(N, 0);

        q.add(first);
        visited[N] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (now.number == G) {
                ans = now.cnt;
                return;
            }

            if (now.cnt >= T) continue;

            if (now.number + 1 < 100_000 && !visited[now.number + 1]) {
                Node next1 = new Node(now.number + 1, now.cnt + 1);
                q.add(next1);
                visited[now.number + 1] = true;
            }

            int buttonB = cal(now.number);

            if (buttonB == -1) continue;
            if (buttonB < 100_000 && !visited[buttonB]) {
                Node next2 = new Node(buttonB, now.cnt + 1);
                q.add(next2);
                visited[buttonB] = true;
            }
        }
    }

    private static int cal (int input) {
        int n = input * 2;

        if (n > 99999) return -1;
        int s = String.valueOf(n).length() - 1;

        return (int) (n - Math.pow(10, s));
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
    }
}
