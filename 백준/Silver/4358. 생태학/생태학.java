import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<String, Integer> map = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = 0;
        String s;
        while ((s = br.readLine()) != null && !s.isEmpty()) {
            total++;
            map.put(s, map.getOrDefault(s, 0)+1);
        }
        List<String> list = new ArrayList<>(map.keySet());

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();

        for (String k : list) {
            int count = map.get(k)*100;
            sb.append(k).append(" ").append(String.format("%.4f", (double) count / (double) total)).append("\n");
        }
        System.out.println(sb);
    }
}
