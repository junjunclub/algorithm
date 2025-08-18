import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in); // 입력

		while (true) { // 라인별 접근을 위한 순한
			String N = sc.nextLine(); // 라인별 접근
			if (N.equals("#")) // 만약 0이라면
				System.exit(0); // 시스템 강제 종료 코드

			String[] arr = N.toLowerCase().split(""); // 해당 문자열 한글자씩 배열 생성

			int count = 0;
			for (String str : arr) { // 순환
				switch (str) {	// switch문을 사용하여 해결
				case "a":
				case "e":
				case "i":
				case "o":
				case "u":
					count++;
				default:
					break;
				}
			}
			System.out.println(count);
		}

	}
}