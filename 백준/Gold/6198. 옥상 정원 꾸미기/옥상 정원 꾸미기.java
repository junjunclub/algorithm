import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static Stack<Integer> stack = new Stack<>();
    static long answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int h = Integer.parseInt(br.readLine());

            while (!stack.isEmpty()) {
                if (stack.peek() <= h) {
                    stack.pop();
                } else {
                    break;
                }
            }
            stack.push(h);
            answer += stack.size()-1;
        }
        System.out.println(answer);
    }
}
