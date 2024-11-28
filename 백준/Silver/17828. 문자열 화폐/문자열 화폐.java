import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean flag = true;

        if (n > m) {
            flag = false;
        }

        if ((m/26) > n) {
            flag = false;
        }

        if (m/26 == n && m%26 != 0) {
            flag = false;
        }

        if (flag) {
            m -= n;
            char[] list = new char[n];

            for (int i = n-1; i >= 0; i--) {
                list[i] = 'A';
                if (m >= 25) {
                    m -= 25;
                    list[i] += 25;
                } else if (m > 0) {
                    list[i] += m;
                    m = 0;
                }
                sb.append(list[i]);
            }
            sb.reverse();
            System.out.println(sb);
        } else {
            System.out.println("!");
        }
    }
}
