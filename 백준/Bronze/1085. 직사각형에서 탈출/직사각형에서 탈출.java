import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int x, y, w, h;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        int xMin = Math.min(x, (w-x));
        int yMin = Math.min(y, (h-y));

        System.out.println(Math.min(xMin, yMin));
    }
}
