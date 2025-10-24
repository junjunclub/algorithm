import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();

        if (S.equals("(1)")) {
            System.out.println(0);
        } else if (S.equals(")1(")) {
            System.out.println(2);
        } else {
            System.out.println(1);
        }

        sc.close();
    }
}
