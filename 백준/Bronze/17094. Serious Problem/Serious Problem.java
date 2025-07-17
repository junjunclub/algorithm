import java.util.Scanner;
 
public class Main {
	public static void main(String args[]) {
	    
		Scanner sc = new Scanner(System.in);
		
		int inputLength = sc.nextInt();
		int count_2 = 0;
		int count_e = 0;
		String inputWord = sc.next();
		
		char[] arr = new char[inputLength];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = inputWord.charAt(i);
			if (arr[i] == '2') {
			    count_2 += 1;
			}
			else {
			    count_e += 1;
			}
		}
		
		if (count_2 == count_e) {
		    System.out.print("yee");
		}
		else if (count_2 > count_e) {
		    System.out.print("2");
		}	
		else {
		    System.out.print("e");
		}
			
	}
}