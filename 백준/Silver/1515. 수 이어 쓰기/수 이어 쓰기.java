import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int pointer = 0;
        int num = 0;

        while (num++ <= 30000) {
            String temp = Integer.toString(num);

            for (int i = 0; i < temp.length(); i++) {
                if (temp.charAt(i) == str.charAt(pointer)) {
                    pointer++;
                }

                if (pointer == str.length()) {
                    System.out.println(num);
                    return;
                }
            }
        }


    }
}
