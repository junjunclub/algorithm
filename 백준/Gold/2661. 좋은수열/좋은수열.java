import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N;
    public static void main(String[] args) throws Exception{
        init();
        solve();
    }

    public static void init () throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
    }

    public static void solve() {
        dfs("");
    }

    public static void dfs(String s) {
        if (s.length() == N) {
            System.out.println(s);
            System.exit(0);
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (canMakeStr(s+i)) {
                dfs(s+i);
            }
        }
    }

    public static boolean canMakeStr(String s) {
        for (int i = 1; i <= s.length() / 2; i++) {
            String front = s.substring(s.length() - i * 2, s.length() - i);
            String back = s.substring(s.length() - i);
            if (front.equals(back)) {
                return false;
            }
        }
        return true;
    }
}
