import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        /**
         * 1. 큐를 만들어주기
         * 2. 현재 인덱스가 단계의 3제곱이라면, 빼주기
         * 3. 아니면 제일 앞에있는거 뒤로 보내주기
         */

        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        long stage = 1;
        int idx = 0;

        while (queue.size() != 1) {
            long num = (long) Math.pow(stage, 3);
            idx = (int) ((idx+num-1) % queue.size());
            queue.remove(idx);
            stage++;
        }
        System.out.println(queue.peek());
    }
}
