import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;

public class Main {
    static LinkedList<Character> linkedList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            linkedList = new LinkedList<>();
            ListIterator<Character> list = linkedList.listIterator();
            String input = br.readLine();

            for (int j = 0; j < input.length(); j++) {
                char c = input.charAt(j);
                if (c == '<') {
                    if (list.hasPrevious()) {
                        list.previous();
                    }
                } else if (c == '>') {
                    if (list.hasNext()) {
                        list.next();
                    }
                } else if (c == '-') {
                    if (list.hasPrevious()) {
                        list.previous();
                        list.remove();
                    }
                } else {
                    list.add(c);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (char c : linkedList) {
                sb.append(c);
            }
            System.out.println(sb);
        }
    }
}
