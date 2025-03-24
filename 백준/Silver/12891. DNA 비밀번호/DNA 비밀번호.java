import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int S, P, A, C, G, T;
    static Map<Character, Integer> map;
    static String s;
    public static void main(String[] args) throws Exception{
        init();
        solve();
    }

    private static void solve() {
        int answer = 0;
        for (int i = 0; i < P; i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        if (map.getOrDefault('A', 0) >= A && map.getOrDefault('C', 0) >= C && map.getOrDefault('G', 0) >= G && map.getOrDefault('T', 0) >= T) answer++;

        for (int i = 1; i < S-P+1; i++) {
            // 처리
            char start = s.charAt(i-1);
            char end = s.charAt(i+P-1);
            map.put(start, map.getOrDefault(start, 0) - 1);
            map.put(end, map.getOrDefault(end, 0) + 1);
            if (map.getOrDefault('A', 0) >= A && map.getOrDefault('C', 0) >= C && map.getOrDefault('G', 0) >= G && map.getOrDefault('T', 0) >= T) answer++;
        }
        System.out.println(answer);
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        s = br.readLine();
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new HashMap<>();
    }
}
