import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static ArrayDeque<Character> ad;
    static List<Character> list;
    public static void main(String[] args) throws Exception{
            init();
            solve();
        }

    private static void solve() {
        StringBuilder sb = new StringBuilder();

        while (!ad.isEmpty()) {
            if (isLeftSmaller()) {
                list.add(ad.pollFirst());
            } else {
                list.add(ad.pollLast());
            }
        }

        for (int i = 0; i < list.size(); i++) {
            if (i != 0 && i % 80 == 0) {
                sb.append("\n");
            }
            sb.append(list.get(i));
        }
        System.out.println(sb);
    }

    private static boolean isLeftSmaller() {
        int l = 0;
        int r = ad.size() - 1;

        Object[] arr = ad.toArray();
        while (l <= r) {
            char left = (char) arr[l];
            char right = (char) arr[r];

            if (left < right) return true;
            if (left > right) return false;
            l++;
            r--;
        }
        return true;
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ad = new ArrayDeque<>();
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            char c = br.readLine().charAt(0);
            ad.add(c);
        }
    }
}
