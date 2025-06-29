import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static String str;
    public static void main(String[] args) throws Exception{
            init();
            solve();
        }

    private static void solve() {
        int num = Integer.parseInt(str, 2);
        int cnt = 0;
        while (true) {
            if (num == 0) break;
            cnt++;
            num = num - (num & ((~num) + 1));
        }
        System.out.println(cnt);
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        str = br.readLine();
    }
}
