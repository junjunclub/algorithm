import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, k;
    static List<Integer> arr;
    public static void main(String[] args) throws Exception{
            init();
            solve();
        }

    private static void solve() {
        System.out.println(arr.get(k - 1));
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(arr);
    }
}
