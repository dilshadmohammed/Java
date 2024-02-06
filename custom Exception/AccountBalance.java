import java.util.Scanner;

class LowBalanceException extends Exception{
    LowBalanceException(String err){
        super(err);
    }
}

class Account {
    int acNo;
    int bal;
    String name;
    Account(int acNo,int bal,String name){
        this.acNo = acNo;
        this.bal = bal;
        this.name = name;
    }
    
    void getDetails() throws LowBalanceException{
        // try{
            if(bal<1000)
                throw new LowBalanceException("Below minimum balance");
            else{
                System.out.println(acNo+" "+name+" "+"Rs."+bal);
            }
        // }
        // catch(LowBalanceException e){
        //     System.out.println(e.getMessage());
        // }
        
    }

}


class AccountBalance {
    public static void main(String[] args) throws LowBalanceException {
        Scanner s = new Scanner(System.in);
        Account customers[] = new Account[3];
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter accout details: ");
            customers[i] = new Account(s.nextInt(), s.nextInt(), s.nextLine());
        }
        for(int i =0;i<3;i++){
            customers[i].getDetails();
        }
    }
}
