import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, answer;
    static List<Line2170> list;
    public static void main(String[] args) throws Exception{
        init();
        solve();
    }

    private static void solve() {
        int start = list.get(0).s;
        int end = list.get(0).e;
        answer = 0;
        int temp = 0;
        for (int i = 1; i < n; i++) {
            Line2170 l = list.get(i);
            // 끊어진다면
            if (end < l.s) {
                answer += Math.abs(end - start);
                start = l.s;
                end = l.e;
            // 이어진다면
            } else {
                end = Math.max(end, l.e);
            }
        }
        answer += end - start;
        System.out.println(answer);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list.add(new Line2170(s, e));
        }

        Collections.sort(list);

    }
}

class Line2170 implements Comparable<Line2170> {
    int s, e;
    public Line2170(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Line2170 l) {
        if (this.s == l.s) {
            return Integer.compare(this.e, l.e);
        }
        return Integer.compare(this.s, l.s);
    }
}