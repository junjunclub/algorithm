import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Map<Character, Integer> map;
    static int N;
    static String[] list;
    public static void main(String[] args) throws Exception{
        init();
        solve();

        /**
         * 1. 많이 나온 수가 9, 그 다음이 8.... 이런식으로
         * 2. 빈도수에 따라서 값 넣어주기
         */
    }

    private static void solve() {
        int answer = 0;

        List<Integer> lst = new ArrayList<>(map.values());
        Collections.sort(lst, Collections.reverseOrder());

        int v = 9;
        for (int i = 0; i < lst.size(); i++) {
            answer += lst.get(i) * v;
            v--;
        }

        System.out.println(answer);
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new HashMap<>();
        list = new String[N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            list[i] = s;
            int len = s.length();
            for (int j = 0; j < s.length(); j++) {
                int pow = (int) Math.pow(10, len-j-1);
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + pow);
            }
        }
    }
}

class Alphabet {
    int idx, v;
    public Alphabet(int idx, int v) {

    }
}
