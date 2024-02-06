abstract class Marks{
    abstract int getPercentage();
}

class A extends Marks{
    int a,b,c;
    A(int a,int b,int c)
    {
        this.a=a;
        this.b=b;
        this.c=c;
    }

    int getPercentage(){
        return (a+b+c)/3;
    }
}

class B extends Marks{
    int a,b,c,d;
    B(int a,int b,int c,int d)
    {
        this.a=a;
        this.b=b;
        this.c=c;
        this.d=d;
    }

    int getPercentage(){
        return (a+b+c+d)/4;
    }
}


class StudentMarks {

    public static void main(String[] args) {
        A a=new A(40, 35, 55);
        B b=new B(50, 60, 70, 20);
        System.out.println("mark of A: "+a.getPercentage());
        System.out.println("mark of B: "+b.getPercentage());
    }
}