import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, L;
    static List<Node1911> list;
    public static void main(String[] args) throws Exception{
        init();
        solve();
    }

    private static void solve() {
        int start = 0;
        int total = 0;

        for (int i = 0; i < N; i++) {
            Node1911 n = list.get(i);

            // 판자 시작지점이 웅덩이 끝보다 더 큰 경우
            if (start > n.e) {
                continue;
            }

            start = Math.max(start, n.s);

            int length = n.e - start;
            int cnt = length % L == 0 ? length / L : (length / L) + 1;

            total += cnt;
            start += cnt * L;
        }
        System.out.println(total);
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list.add(new Node1911(s, e));
        }
        Collections.sort(list);
    }
}

class Node1911 implements Comparable<Node1911>{
    int s, e;
    public Node1911(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Node1911 n) {
        if (n.e == this.e) {
            return Integer.compare(this.s, n.s);
        } else {
            return Integer.compare(this.e, n.e);
        }
    }
}
