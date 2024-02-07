import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class LongestWord {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("inputfile.txt"));
        String longestword="";
        while (s.hasNextLine()) {
            StringTokenizer strToken = new StringTokenizer(s.nextLine());
            while (strToken.hasMoreTokens()) {
                String str = strToken.nextToken();
                if(str.length() > longestword.length())
                    longestword = str;
            }
        }
        System.out.println("Longest word: "+longestword);
    }    
}
