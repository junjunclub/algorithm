import java.util.*;
import java.io.*;

public class Main {
	static int N, R;
	static Map<String, Integer> stationInfo;
	static Map<String, Integer> characterInfo;
	static int startNum = 0;
	static int[] cntArr;
	
	public static void main (String[] args) throws Exception{
		init();
	}
	
	private static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		cntArr = new int[513];
		
		stationInfo = new HashMap<>();
		characterInfo = new HashMap<>();
		
		// 역 이름 Map에 저장
		for (int i = 0; i < N; i++) {
			String stationName = br.readLine();
			stationInfo.put(stationName, 0);
		}
		
		R = Integer.parseInt(br.readLine());
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			
			if (command.equals("U")) {
				String stationName = st.nextToken();
				String[] characters = st.nextToken().split(",");
				
				// 특징 집어넣기
				putCharacters(stationName, characters);
				
			} else if (command.equals("G")) {
				boolean flag = true;
				String[] characters = st.nextToken().split(",");

				// characterInfo 맵에서 characterName의 값을 가져오고,
				int num = 0;
				
				for (int j = 0; j < characters.length; j++) {
					if (!characterInfo.containsKey(characters[j])) {						
						flag = false;
						break;
					} else {
						num |= 1 << characterInfo.get(characters[j]);
					}
				}
				
//				System.out.println("조회할 cntArr의 IDX : "+num);
				
				if (flag) {
					
					System.out.println(cntArr[num]);
				} else {
					System.out.println(0);
				}
			}
		}
	}
	
	private static void putCharacters (String stationName, String[] characters) {
		// 값이 기존에 있을 경우 제거해주기
		if (stationInfo.get(stationName) != 0) {
			calculate(stationName, -1);
		}
		
		// 값 새로 추가해주기
		int n = 0;
		for (int i = 0; i < characters.length; i++) {
			// 이미 값이 있는 경우
			if (!characterInfo.containsKey(characters[i])) {
				characterInfo.put(characters[i], startNum++);
			}
			
			n |= 1 << characterInfo.get(characters[i]);
		}
//		System.out.println("특징 정보 : "+characterInfo);
//		System.out.println("역의 특징을 Integer로 바꾼 값 : "+n);
		
		stationInfo.put(stationName, n);
		calculate(stationName, 1);
	}
	
	private static void calculate (String stationName, int flag) {
//		System.out.println("역 이름 : "+stationName);
		int num = stationInfo.get(stationName);
//		System.out.println("역의 특징 이름 : "+num);
		for (int i = 0; i <= 512; i++) {
			if ((i & num) == i) {
				cntArr[i] += 1 * flag;
			}
		}
//		System.out.println("=====");
//		System.out.println(Arrays.toString(cntArr));
//		System.out.println("=====");
	}
}
