import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static String str1, str2;
    public static void main(String[] args) throws Exception{
            init();
            solve();
        }

    private static void solve() {
        int idx = 0;
        int answer = 0;
        while (idx < str1.length() - str2.length() + 1) {
            if (str1.charAt(idx) == str2.charAt(0)) {
                int temp = 1;
                for (int i = 1; i < str2.length(); i++) {
                    if (str1.charAt(idx + i) == str2.charAt(i)) {
                        temp++;
                    } else {
                        break;
                    }
                }
                if (temp == str2.length()) {
                    answer++;
                    idx += str2.length();
                } else {
                    idx++;
                }
            } else {
                idx++;
            }
        }
        System.out.println(answer);
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str1 = br.readLine();
        str2 = br.readLine();
    }
}
