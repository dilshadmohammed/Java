import java.util.Scanner;
import java.util.StringTokenizer;


public class Token {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the string");
        StringTokenizer t = new StringTokenizer(s.nextLine(),"aeiouAEIOU");
        while (t.hasMoreTokens()) {
            System.out.print(t.nextToken());
        }
        

    }
}
