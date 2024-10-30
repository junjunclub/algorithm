import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        int n = Integer.parseInt(br.readLine());
        String[] list = new String[n];
        for (int i = 0; i < n; i++) {
            list[i] = br.readLine();
        }

        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if (similar(list[i], list[j])) {
                    answer++;
                }
            }
        }
        System.out.println(answer);

    }

    private static boolean similar(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        HashMap<Character, Character> map = new HashMap<>();
        for (int k = 0; k < s1.length(); k++) {
            char c1 = s1.charAt(k);
            char c2 = s2.charAt(k);

            if (map.containsKey(c1)) {
                if (map.get(c1) != c2) {
                    return false;
                }
            } else {
                if (map.containsValue(c2)) {
                    return false;
                }
                map.put(c1, c2);
            }
        }
        return true;
    }
}
