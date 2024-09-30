import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean flag;
    static String s;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        int len = s.length();

        flag = true;

        pal(0, len-1);

        for (int i = len/2; i > 0 && flag; i /= 2) {
            pal(0, i-1);
        }

        if (flag) {
            System.out.println("AKARAKA");
        } else {
            System.out.println("IPSELENTI");
        }

    }

    private static void pal(int l, int r) {
        if (l >= r) {
            flag = true;
            return;
        }

        if (s.charAt(l) == s.charAt(r)) {
            pal(l+1, r-1);
        } else {
            flag = false;
        }

    }
}
