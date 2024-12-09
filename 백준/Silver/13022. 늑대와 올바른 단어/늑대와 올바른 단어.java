import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    static int[] count;
    static boolean flag = true;
    static String word;
    static int wCnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        word = br.readLine();

        /**
         * 1. w의 갯수를 확인
         * 2. w의 갯수를 기반으로 o, l, f의 갯수를 확인하는 함수 넣기
         * 3. 판별하는 함수를 정상적으로 통과하면 flag를 true, 아니면 false를 반환
         */
        if (word.length() < 4) {
            System.out.println(0);
        } else {
            count = new int[4];
            HashMap<Character, Integer> map = new HashMap<>();

            map.put('w', 0);
            map.put('o', 1);
            map.put('l', 2);
            map.put('f', 3);
            count[map.get(word.charAt(0))] = 1;
            for (int i = 1; i < word.length(); i++) {
                int pre = map.get(word.charAt(i-1));
                int cur = map.get(word.charAt(i));
                int diff = cur - pre;

                if (diff == -3) {
                    if (check()) {
                        count = new int[4];
                        count[0] = 1;
                    } else {
                        flag = false;
                        break;
                    }
                } else {
                    if (diff == 1 || diff == 0) {
                        count[cur]++;
                    } else {
                        flag = false;
                        break;
                    }
                }
            }
            if (!check()) {
                flag = false;
            }
            if (flag) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }

    private static boolean check() {
        if (count[0] == count[1] && count[1] == count[2] && count[2] == count[3]) {
            return true;
        } else {
            return false;
        }
    }
}
