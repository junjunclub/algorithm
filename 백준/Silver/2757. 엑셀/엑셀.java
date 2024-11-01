import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String s;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            s = br.readLine();
            if (s.equals("R0C0")) break;
            StringTokenizer st = new StringTokenizer(s, "RC");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            StringBuilder tmp = new StringBuilder();
            while (m > 0) {
                m--;
                tmp.append((char)('A'+m%26));
                m /= 26;
            }
            sb.append(tmp.reverse()).append(n).append("\n");
        }
        System.out.println(sb);
    }
}
