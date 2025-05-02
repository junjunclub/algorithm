import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static List<Integer> list;
    static String str;
    public static void main(String[] args) throws Exception{
            init();
            solve();
        }

    private static void solve() {
        int ans = Math.abs(100 - Integer.parseInt(str));
        int cnt = Integer.MAX_VALUE;

        for (int i = 0; i <= 999999; i++) {
            String num = String.valueOf(i);
            boolean flag = true;
            for (int j = 0; j < num.length(); j++) {
                if (N != 0 && list.contains(num.charAt(j) - '0')) {
                    flag = false;
                    break;
                }
            }
            if (!flag) continue;

            int temp = num.length() + Math.abs(i - Integer.parseInt(str));
            if (temp < cnt) {
                cnt = temp;
            }
        }
        System.out.println(Math.min(cnt, ans));
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        if (N != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
        }
    }
}
