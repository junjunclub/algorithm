import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        HashMap<String, Integer> map = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String word = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            map.put(word, num);
            queue.add(word);
        }
//        System.out.println(map);
//        System.out.println(queue);

        while (queue.size() > 1) {
            String student = queue.poll();
            int n = map.get(student);

            for (int i = 0; i < n-1; i++) {
                queue.add(queue.poll());
            }
            queue.poll();
        }
        System.out.println(queue.poll());
    }
}
