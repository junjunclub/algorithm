import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String answer = "";
        int num = 987654321;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();
            int tempNum = Integer.parseInt(st.nextToken());

            if (tempNum < num) {
                answer = temp;
                num = tempNum;
            }
        }
        System.out.println(answer);
    }
}
