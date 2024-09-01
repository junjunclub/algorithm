import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Queue<Integer> q;
    static List<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        q = new LinkedList<>();
        list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            q.add(i+1);
        }

        while (!q.isEmpty()) {
            list.add(q.poll());
            if (!q.isEmpty()) {
                q.add(q.poll());
            }
        }

        for (int v : list) {
            System.out.print(v + " ");
        }
    }
}
