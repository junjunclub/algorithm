import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    static int n, answer;
    static int[] arr;
    static Set<Integer> set;

    public static void main(String[] args) throws Exception{
        init();
        solve();
    }

    private static void solve() {
        answer = 0;
        for (int i = n-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (set.contains(arr[i]-arr[j])) {
                    answer = Math.max(arr[i], answer);
                }
            }
        }

        System.out.println(answer);
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        set = new HashSet<>();

        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                set.add(arr[i]+arr[j]);
            }
        }
    }
}
