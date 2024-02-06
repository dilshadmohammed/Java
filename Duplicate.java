public class Duplicate {
    public static void main(String[] args) {
        String str = "Java is simple but powerful";
        String dup = "";
        for(int i=0;i<str.length()-1;i++){
            for(int j=i+1;j<str.length();j++){
                if(str.charAt(i) == str.charAt(j) && !dup.contains(str.charAt(i)+"")){
                    dup+=str.charAt(i)+" ";
                }
            }
        }
        System.out.println(dup);
        System.out.println(str);
    }
}
