import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
   
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      
      while(true) {
    	  String str = br.readLine();
    	  if( str.equals("#")) {
    		  break;
    	  } else {
    		  String word = String.valueOf(str.charAt(0));
    		  int result = countWord(str,word)-1;
    		  bw.write(word + " " + result +"\n");
    	  }
      }
      
      bw.flush();
      bw.close();
      br.close();
   }
   
   static int countWord(String s,String word) {
	   int n1 = s.length() - s.replace(word.toLowerCase(), "").length();
	   int n2 = s.length() - s.replace(word.toUpperCase(), "").length();
	   return n1+n2;
   }
}