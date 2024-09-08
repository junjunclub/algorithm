import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        Set<Character> set = new HashSet<>();

        while ((s = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(s);
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int result = 0;

            for (int i = n; i <= m; i++) {
                String num = Integer.toString(i);
                Boolean flag = true;
                for (int j = 0; j < num.length(); j++) {
                    if (set.contains(num.charAt(j))) {
                        flag = false;
                        break;
                    } else {
                        set.add(num.charAt(j));
                    }
                }
                set.clear();
                if (flag) {
                    result++;
                }
            }
            System.out.println(result);
        }
    }
}
