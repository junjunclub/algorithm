import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static Set<String> set;
    public static void main(String[] args) throws Exception{
            init();
        }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st;

        int ans = 1;

        set = new HashSet<>();

        set.add("ChongChong");

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s1 = st.nextToken();
            String s2 = st.nextToken();

            if (set.contains(s1) && !set.contains(s2)) {
                set.add(s2);
                ans++;
            } else if (set.contains(s2) && !set.contains(s1)) {
                set.add(s1);
                ans++;
            }
        }
        System.out.println(ans);
    }
}
