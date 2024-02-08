import java.util.Scanner;

class NonMultipliableMatrixException extends Exception {
    NonMultipliableMatrixException(String e)
    {
        super(e);
    }
}

class Matrix {
    int[][] arr;
    Scanner s = new Scanner(System.in);
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

    void readMatrix(){
        for(int i=0;i<arr.length;i++)
            for(int j=0;j<arr[0].length;j++)
            {
                arr[i][j] = s.nextInt();
            }
    }

    void printMatrix(){
        for(int[] i: arr)
            {    for(int j: i)
                {
                    System.out.print(j+" ");
                }
                System.out.println();
            }
    }

    Matrix multiply(Matrix B){
        int R1 = arr.length;
        int C1 = arr[0].length;
        int R2 = B.arr.length;
        int C2 = B.arr[0].length;
        try{
            int[][] result= new int[R1][C2];
            if(C1 != R2){
                throw new NonMultipliableMatrixException("Matrix cannot be multiplied Not compatible");
            }
            else{
                for(int i=0; i<R1 ; i++){
                    for(int j=0; j<C2; j++){
                        for(int k=0 ; k<R2; k++){
                            result[i][j] += arr[i][k]*B.arr[k][j];
                        }
                    }
                }
            }

            return new Matrix(result);
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
        
    }

    public static void main(String[] args) {
        Matrix A = new Matrix(new int[3][3]);
        Matrix B = new Matrix(new int[5][5]);
        System.out.println("Enter Matrix A: ");
        A.readMatrix();
        System.out.println("Enter Matrix B: ");
        B.readMatrix();
        Matrix C = A.multiply(B);
        System.out.println("Result Matrix c: ");
        C.printMatrix();
    }
}
