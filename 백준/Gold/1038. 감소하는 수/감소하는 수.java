import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static Set<Long> set;
    public static void main(String[] args) throws Exception{
        init();
        solve();
    }

    private static void solve() {
        if (N < 10) {
            System.out.println(N);
            return;
        } else if (N > 1022) {
            System.out.println(-1);
            return;
        } else {
            for (int i = 0; i < 10; i++) {
                makeList(i);
            }
        }
        List<Long> list = new ArrayList<>(set);

        Collections.sort(list);

        System.out.println(list.get(N));
    }

    private static void makeList(long n) {
        set.add(n);
        for (int i = 0; i < n % 10; i++) {
            makeList((n*10) + i);
        }
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        set = new HashSet<>();
    }
}
