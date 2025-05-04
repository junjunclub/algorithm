import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static String str;
    static Map<Character, Integer> map;
    public static void main(String[] args) throws Exception{
            init();
            solve();
        }

    private static void solve() {
        map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < map.getOrDefault('0', 0) / 2; i++) {
            sb.append('0');
        }

        for (int i = 0; i < map.getOrDefault('1', 0) / 2; i++) {
            sb.append('1');
        }

        System.out.println(sb);
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
    }
}
