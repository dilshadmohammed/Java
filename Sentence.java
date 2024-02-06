import java.util.StringTokenizer;

public class Sentence {
    static String reverseWord(String a){
        String rev="";
        for(int i=0;i<a.length();i++)
            rev = a.charAt(i)+rev;
        return rev;
    }
    public static void main(String[] args) {
        String str = "Hello World this is a sentence";
        // StringTokenizer strToken = new StringTokenizer(str);
        // str = "";
        // while (strToken.hasMoreTokens()) {
        //     str = str+" "+reverseWord(strToken.nextToken());
        // }



        // String[] strings = str.split(" ");
        // str = "";
        // for(String i: strings)
        //     {
        //         str = str+" "+reverseWord(i);
        //     }

        
        StringTokenizer strToken = new StringTokenizer(str);
            str = "";
        while (strToken.hasMoreTokens()) {
            StringBuffer newString = new StringBuffer(strToken.nextToken());

            str = str+" "+newString.reverse();
        }
        System.out.println("Reversed sentence: ");
        System.out.println(str);
    }
}
