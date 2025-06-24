import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static Map<String, Integer> map;
    public static void main(String[] args) throws Exception{
            init();
            solve();
        }

    private static void solve() {
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>(map.keySet());

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (map.get(o1) != map.get(o2)) {
                    return Integer.compare(map.get(o2), map.get(o1));
                }
                if (o1.length() != o2.length()) {
                    return Integer.compare(o2.length(), o1.length());
                }
                return o1.compareTo(o2);
            }
        });

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() >= M) {
                sb.append(list.get(i)).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        map = new HashMap<>();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
    }
}
