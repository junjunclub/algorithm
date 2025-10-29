import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Prob implements Comparable<Prob>{
        int day, ramen;

        public Prob (int day, int ramen) {
            this.day = day;
            this.ramen = ramen;
        }
        @Override
        public int compareTo (Prob p) {
            if (p.day != this.day) {
                return Integer.compare(this.day, p.day);
            }
            return Integer.compare(p.ramen, this.ramen);
        }
    }

    static int N;

    static Queue<Integer> pq = new PriorityQueue<>();
    static Prob[] arr;
    public static void main(String[] args) throws Exception{
        init();
        solve();
    }

    private static void solve() {
        for (int i = 0; i < N; i++) {
            pq.add(arr[i].ramen);

            if (arr[i].day < pq.size()) {
                pq.poll();
            }
        }

        int ans = 0;

        for (Integer ramenCnt : pq) {
            ans += ramenCnt;
        }

        System.out.println(ans);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new Prob[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            arr[i] = new Prob(d, r);
        }

        Arrays.sort(arr);
    }
}
