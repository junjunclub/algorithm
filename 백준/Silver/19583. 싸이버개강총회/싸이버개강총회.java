import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static String S, E, Q;
    static Set<String> after, before, name;
    public static void main(String[] args) throws Exception{
        init();
        solve();
    }

    private static void solve() {
        int answer = 0;
        for (String n : name) {
            if (after.contains(n) && before.contains(n)) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        S = st.nextToken();
        E = st.nextToken();
        Q = st.nextToken();

        before = new HashSet<>();
        after = new HashSet<>();
        name = new HashSet<>();

        String input;

        while ((input = br.readLine()) != null) {
            st = new StringTokenizer(input);
            String t = st.nextToken();
            String n = st.nextToken();

            name.add(n);

            if (S.compareTo(t) >= 0) {
                before.add(n);
            } else if (E.compareTo(t) <= 0 && Q.compareTo(t) >= 0) {
                after.add(n);
            }
        }
    }
}
