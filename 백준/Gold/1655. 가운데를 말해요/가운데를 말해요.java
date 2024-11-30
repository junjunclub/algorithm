import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        PriorityQueue<Integer> maxPq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (maxPq.size() == minPq.size()) {
                maxPq.add(num);
            } else {
                minPq.add(num);
            }

            if (!minPq.isEmpty() && !maxPq.isEmpty() && minPq.peek() < maxPq.peek()) {
                int temp = minPq.poll();
                minPq.add(maxPq.poll());
                maxPq.add(temp);
            }
            sb.append(maxPq.peek() + "\n");
        }
        System.out.println(sb);
    }
}
