import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int n;
    public static void main(String[] args) throws Exception{
        init();
        solve();
    }

    private static void solve() {
        StringBuilder sb = new StringBuilder();
        double tax = n * 0.2;
        double resultTax = tax * 0.22;
        sb.append((int) (n * 0.78)).append(" ");
        sb.append((int) (n - resultTax));
        System.out.println(sb);
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
    }
}
