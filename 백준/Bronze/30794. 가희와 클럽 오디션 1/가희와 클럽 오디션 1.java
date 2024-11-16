import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        String p = st.nextToken();
        int answer = 0;
        if (p.equals("miss")) {
        } else if (p.equals("bad")) {
            answer = 200 * n;
        } else if (p.equals("cool")) {
            answer = 400 * n;
        } else if (p.equals("great")) {
            answer = 600 * n;
        } else if (p.equals("perfect")) {
            answer = 1000 * n;
        }
        System.out.println(answer);
    }
}
