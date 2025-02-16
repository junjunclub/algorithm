import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int n;
    public static void main(String[] args) throws Exception{
        init();
        solve();
    }

    private static void solve() {
        System.out.println(factorial(n));
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
    }

    private static long factorial (int n) {
        if (n == 0) {
            return 1;
        }

        return n * factorial( n - 1);
    }
}
