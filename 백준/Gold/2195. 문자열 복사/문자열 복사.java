import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br;
    static char[] list1;
    static char[] list2;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        /**
         * 1. 투포인터로 풀 수 있을 것 같다!
         * 2. 시작점과 같은 문자일지라도, 뒤에 나온 문자가 더 유사할 수 있음.
         */

        int idx = 0;
        while (idx < list2.length) {
            int increase = 0;

            for (int i = 0; i < list1.length; i++) {
                int temp = 0;
                for (int j = i; j < list1.length; j++) {
                    int idx2 = temp + idx;
                    if (idx2 < list2.length && list1[j] == list2[idx2]) {
                        temp++;
                    } else {
                        break;
                    }
                }
                if (temp > increase) {
                    increase = temp;
                }
            }

            idx += increase;
            answer++;
        }

        System.out.println(answer);
    }

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        list1 = br.readLine().toCharArray();
        list2 = br.readLine().toCharArray();
    }
}
