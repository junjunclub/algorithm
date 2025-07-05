import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, answer, tempV;
    static long maxV;
    static Map<String, Long> map;
    static List<String> list;
    public static void main(String[] args) throws Exception{
            init();
            solve();
        }

    private static void solve() {
        list = new ArrayList<>(map.keySet());
        answer = 50;
        tempV = 0;
        if (maxV == 0) {
            System.out.println(-1);
        } else {
            for (int i = 0; i < list.size(); i++) {
                comb(i + 1, 1, map.get(list.get(i)));
            }
            System.out.println(answer);
        }
    }

    private static void comb(int idx, int cnt, long v) {
        if (v == maxV) {
            answer = Math.min(answer, cnt);
            return;
        }

        if (idx == list.size()) return;

        for (int i = idx; i < list.size(); i++) {
            comb(i + 1, cnt + 1, v | map.get(list.get(i)));
        }
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        map = new HashMap<>();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maxV = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String g = st.nextToken();
            String parsingNum = st.nextToken().replace('Y', '1').replace('N', '0');
            long v = Long.parseLong(parsingNum, 2);
            maxV = maxV | v;
            map.put(g, v);
        }
    }
}
