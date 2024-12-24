import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<Character, Integer> map = new HashMap<>();
        String input = br.readLine();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            map.put((char) (i + 65), num);
        }

        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+') {
                double num1 = stack.pop();
                double num2 = stack.pop();
                stack.add(num2 + num1);
            } else if (input.charAt(i) == '-') {
                double num1 = stack.pop();
                double num2 = stack.pop();
                stack.add(num2 - num1);
            } else if (input.charAt(i) == '*') {
                double num1 = stack.pop();
                double num2 = stack.pop();
                stack.add(num2 * num1);
            } else if (input.charAt(i) == '/') {
                double num1 = stack.pop();
                double num2 = stack.pop();
                stack.add(num2 / num1);
            } else {
                stack.add((double) map.get(input.charAt(i)));
            }
        }

        System.out.println(String.format("%.2f",stack.get(0)));
    }
}
