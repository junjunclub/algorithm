import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int total;
    public static void main(String[] args) throws Exception{
            init();
            solve();
        }

    private static void solve() {
        StringBuilder sb = new StringBuilder();
        sb.append(total / 60).append("\n").append(total % 60);
        System.out.println(sb);
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        total = 0;
        for (int i = 0; i < 4; i++) {
            total += Integer.parseInt(br.readLine());
        }
    }
}

