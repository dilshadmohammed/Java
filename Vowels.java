import java.io.*;

class Vowels {

    public static void main(String[] args){
        try{
            FileReader fr = new FileReader("input.txt");
            FileWriter fw = new FileWriter("output.txt");

            int i;
            int vowels = 0, totalcount = 0;
            ;

            while ((i = fr.read()) != -1) {
                char c = (char) i;
                switch (c) {
                    case 'a':
                    case 'e':
                    case 'i':
                    case 'o':
                    case 'u':
                        vowels++;

                }
                totalcount++;
            }
            fr.close();
            fw.write("vowels: " + vowels + "\nLenght: " + totalcount);
            fw.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}