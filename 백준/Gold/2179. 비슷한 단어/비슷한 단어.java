import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            list.add(s);
        }

        int num1 = 0;
        int num2 = 0;
        int maxV = 0;
        for (int i = 0; i < list.size(); i++) {
            String word1 = list.get(i);
            for (int j = i+1; j < list.size(); j++) {
                String word2 = list.get(j);
                int cnt = 0;
                int size = Math.min(word1.length(), word2.length());
                for (int k = 0; k < size; k++) {
                    if (word1.charAt(k) == word2.charAt(k)) {
                        cnt++;
                    } else {
                        break;
                    }

                    if (cnt > maxV) {
                        maxV = cnt;
                        num1 = i;
                        num2 = j;
                    }
                }
            }
        }

        System.out.println(list.get(num1));
        System.out.println(list.get(num2));
    }
}
