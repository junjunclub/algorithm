import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String s;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while ((s = br.readLine()) != null && !s.isEmpty()) {
            StringTokenizer st = new StringTokenizer(s);
            String string1 = st.nextToken();
            String string2 = st.nextToken();

            int idx1 = 0;
            int idx2 = 0;
            boolean flag = false;
            while (idx1 <= string1.length() && idx2 <= string2.length()) {
                if (idx1 == string1.length()) {
                    flag = true;
                    break;
                }

                if (idx2 == string2.length()) {
                    break;
                }

                if (string1.charAt(idx1) == string2.charAt(idx2)) {
                    idx1++;
                    idx2++;
                } else {
                    idx2++;
                }
            }

            if (flag) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
