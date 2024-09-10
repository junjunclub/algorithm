import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < H; i++) {
            String sky = br.readLine();
            int cloud = -1;
            for (int j = 0; j < W; j++) {
                if (sky.charAt(j) == 'c') {
                    sb.append("0 ");
                    cloud = j;
                } else if (cloud == -1) {
                    sb.append("-1 ");
                } else {
                    sb.append(j-cloud+ " ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString().trim());
    }
}
