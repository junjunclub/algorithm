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
        int answer = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        str = br.readLine();
    }
}
