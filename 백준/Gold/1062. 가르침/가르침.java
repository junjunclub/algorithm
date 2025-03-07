import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, k, bit, answer;
    static String[] list;

    public static void main(String[] args) throws Exception{
        init();
        solve();
        System.out.println(answer);
    }

    private static void solve() {
        if (k < 5) {
            answer = 0;
            return;
        }
        backTracking(0, 5, bit);
    }

    private static void backTracking(int idx, int cnt, int b) {
        if (cnt == k) {
            int canRead = 0;

            for (String word : list) {
                boolean flag = true;

                for (int i = 0; i < word.length(); i++) {
                    if ((b & (1 << (word.charAt(i) - 'a'))) == 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag) canRead++;
            }
            answer = Math.max(canRead, answer);
            return;
        }

        for (int i = idx; i < 26; i++) {
            if ((b & (1 << i)) == 0) {
                backTracking(i+1, cnt+1, b | (1 << i));
            }
        }
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        bit |= (1 << ('a'-'a'));
        bit |= (1 << ('c'-'a'));
        bit |= (1 << ('i'-'a'));
        bit |= (1 << ('n'-'a'));
        bit |= (1 << ('t'-'a'));

        list = new String[n];

        for (int i = 0; i < n; i++) {
            list[i] = br.readLine();
        }
    }
}
