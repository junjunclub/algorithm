import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine()) - 1; // 문자열의 개수
		sb.append("LoveisKoreaUniversity");
		
		// 개수만큼 문자열 붙이기
		while (n-- > 0) {
			sb.append(" LoveisKoreaUniversity");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}