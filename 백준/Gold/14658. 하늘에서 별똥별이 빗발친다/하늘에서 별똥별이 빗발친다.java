import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M, L, K;
    static List<Node14658> list;
    public static void main(String[] args) throws Exception{
            init();
            solve();
        }

    private static void solve() {
        int answer = 0;
        for (Node14658 n1 : list) {
            for (Node14658 n2 : list) {
                answer = Math.max(answer, throwNet(n1.x, n2.y, L));
            }
        }
        System.out.println(K - answer);
    }

    private static int throwNet(int r, int c, int l) {
        int cnt = 0;
        for (Node14658 n : list) {
            if (n.x >= r && n.x <= r + l && n.y >= c && n.y <= c + l) {
                cnt++;
            }
        }
        return cnt;
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Node14658 n = new Node14658(x, y);
            list.add(n);
        }
    }
}

class Node14658 {
    int x, y;
    public Node14658 (int x, int y) {
        this.x = x;
        this.y = y;
    }
}

