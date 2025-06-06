import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, max;
    static PriorityQueue<Lecture2109> pq;
    public static void main(String[] args) throws Exception{
            init();
            solve();
        }

    private static void solve() {
        long answer = 0;
        boolean[] visited = new boolean[max + 1];
        while (!pq.isEmpty()) {
            Lecture2109 l = pq.poll();
            for (int i = l.day; i >= 1; i--) {
                if (!visited[i]) {
                    visited[i] = true;
                    answer += l.pay;
                    break;
                }
            }
        }
        System.out.println(answer);
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        pq = new PriorityQueue<>();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            max = Math.max(d, max);
            Lecture2109 l = new Lecture2109(p, d);
            pq.add(l);
        }
    }
}

class Lecture2109 implements Comparable<Lecture2109> {
    int pay, day;
    public Lecture2109(int pay, int day) {
        this.pay = pay;
        this.day = day;
    }

    @Override
    public int compareTo(Lecture2109 l) {
        if (this.pay == l.pay) {
            return Integer.compare(l.day, this.day);
        }
        return Integer.compare(l.pay, this.pay);
    }
}
