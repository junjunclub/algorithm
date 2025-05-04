import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static char[] list;
    public static void main(String[] args) throws Exception{
            init();
            solve();
        }

    private static void solve() {
        int zeroCnt = 0;
        int oneCnt = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i] == '0') {
                zeroCnt++;
            } else {
                oneCnt++;
            }
        }

        zeroCnt /= 2;
        oneCnt /= 2;

        for (int i = 0; i < list.length; i++) {
            if (list[i] == '1' && oneCnt > 0) {
                list[i] = '-';
                oneCnt--;
                if (oneCnt <= 0) break;
            }
        }

        for (int i = list.length - 1; i >= 0; i--) {
            if (list[i] == '0' && zeroCnt > 0) {
                list[i] = '-';
                zeroCnt--;
                if (zeroCnt <= 0) break;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < list.length; i++) {
            if (list[i] == '0') {
                sb.append('0');
            } else if (list[i] == '1') {
                sb.append('1');
            }
        }

        System.out.println(sb);
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        list = br.readLine().toCharArray();
    }
}
