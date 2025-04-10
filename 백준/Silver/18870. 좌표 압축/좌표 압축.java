import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static Map<Integer, Integer> map;
    static int[] array;
    static int[] origin;
    public static void main(String[] args) throws Exception{
        init();
        solve();
    }

    private static void solve() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            sb.append(map.get(origin[i])).append(" ");
        }

        System.out.println(sb);
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        array = new int[N];
        origin = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            array[i] = num;
            origin[i] = num;
        }

        Arrays.sort(array);

        map = new HashMap<>();
        int n = 0;
        for (int i = 0; i < N; i++) {
            // 키는 배열의 숫자, 값은 순위
            if (!map.containsKey(array[i])) {
                // 포함하지 않을 떄만
                map.put(array[i], n);
                n++;
            }
        }

    }
}

class Node18870 {
    int v, idx;
    public Node18870 (int v, int idx) {
        this.v = v;
        this.idx = idx;
    }
}
