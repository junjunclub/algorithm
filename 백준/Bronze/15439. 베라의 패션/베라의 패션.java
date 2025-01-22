import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        System.out.println(n * (n-1));
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
    }
}
