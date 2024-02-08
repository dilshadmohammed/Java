import java.util.Scanner;

public class Matrix {
    int[][] arr;

    Matrix(int[][] arr){
        this.arr = arr;
    }

    void isSquare(){
        if(arr.length == arr[0].length){
            System.out.println("is a square matrix");
        }
        else{
            System.out.println("not a square matrix");
        }
    }

    void transpose(){
        for(int i=0; i<arr.length/2;i++)
            for(int j=0; j<arr[0].length/2;j++)
            {
               int temp = arr[i][j];
               arr[i][j] = arr[j][i];
               arr[j][i] = temp; 
            }

            for(int[] i: arr)
            {    for(int j: i)
                {
                    System.out.print(j+" ");
                }
                System.out.println();
            }
    }

    void multiply(){
        int []
    }

    public static void main(String[] args) {
        int[][] a = new int[3][4];
        Scanner s = new Scanner(System.in);
        for(int i=0;i<3;i++)
        for(int j=0;j<3;j++)
        {
            a[i][j] = s.nextInt();
        }

        Matrix m = new Matrix(a);
        m.isSquare();
        m.transpose();
    }
}
