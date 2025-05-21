import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static String str;
    public static void main(String[] args) throws Exception{
            init();
            solve();
        }

    private static void solve() {
        char[] cs = {'U', 'C', 'P', 'C'};
        int idx = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (cs[idx] == c) {
                idx++;
            }
            if (idx == 4) {
                break;
            }
        }
        if (idx == 4) {
            System.out.println("I love UCPC");
        } else {
            System.out.println("I hate UCPC");
        }
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
    }
}
