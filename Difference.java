public class Difference {
    public static void main(String[] args) {
        int[] numbers = {5,4,8,2,7,1,9};
        int maxa=0,maxb=0,mina=0,minb=0,diff,minDiff=Integer.MAX_VALUE,maxDiff=Integer.MIN_VALUE;

        for(int i=0;i<numbers.length-1;i++){
            for(int j=i+1;j<numbers.length;j++){
                diff = Math.abs(numbers[i]-numbers[j]);
                if(diff < minDiff)
                {
                    minDiff = diff;
                    mina = numbers[i];
                    minb = numbers[j];
                }
                if(diff > maxDiff)
                {
                    maxDiff = diff;
                    maxa = numbers[i];
                    maxb = numbers[j];
                }
            }
        }

        System.out.println("minimum difference pair: "+minDiff+" |"+mina+" "+minb);
        System.out.println("maximum difference pair: "+maxDiff+" |"+maxa+" "+maxb);
        
    }
}
