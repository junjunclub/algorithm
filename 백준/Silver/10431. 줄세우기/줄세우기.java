import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            List<Integer> list = new ArrayList<>();
            int cnt = 0;
            for (int j = 0; j < 20; j++) {
                int num = Integer.parseInt(st.nextToken());
                list.add(num);
                Collections.sort(list);
                int temp = list.indexOf(num);
                cnt += (list.size() - 1) - temp;
            }
            sb.append(n).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
