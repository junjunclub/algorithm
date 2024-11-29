import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<String> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            String cheese = st.nextToken();
            if (cheese.endsWith("Cheese") && !list.contains(cheese)) {
                list.add(cheese);
            }
        }

        if (list.size() >= 4) {
            System.out.println("yummy");
        } else {
            System.out.println("sad");
        }
    }
}
