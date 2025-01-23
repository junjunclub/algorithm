import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long n,m;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        if (n == m) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Long.parseLong(st.nextToken());
        m = Long.parseLong(st.nextToken());
    }
}
