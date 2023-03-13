import java.util.Scanner;

class Account_Node{
    int account_no;
    String name;
    String address;
    int balance;
    Account_Node next;
    
    Account_Node(int accno,String name,String address,int bal){
        this.account_no=accno;
        this.name=name;
        this.address=address;
        this.balance=bal;
        this.next=null;
    }
}

class bank{
    Account_Node head = null;
    Account_Node ptr;
    int account_no;
    String name;
    String address;
    int balance;
    Scanner sc=new Scanner(System.in);
    public void insert() {
        System.out.print("Enter your account no: ");
        account_no=sc.nextInt();
        sc.nextLine();
        System.out.print("Enter your name: ");
        name=sc.nextLine();
        System.out.print("Enter your address: ");
        address=sc.nextLine();
        System.out.print("Enter your balance: ");
        balance=sc.nextInt();
        sc.nextLine();
        Account_Node temp=new Account_Node(account_no,name,address,balance);

        if(head==null) {
            head=temp;
        }
        else {
            ptr=head;
            while(ptr.next!=null) {
                ptr=ptr.next;
            }
            ptr.next=temp;
        }

    }

// Function to display customers
public void display() {

        if(head==null) {
            System.out.println("List is empty");
            return;
        }
        Account_Node ptr1=head;
        while(ptr1!=null) {
            System.out.println("Account No: "+ptr1.account_no+"\nName: "+ptr1.name+"\nAddress: "+ptr1.address+"\nBalance = "+ptr1.balance);
            ptr1=ptr1.next;
        }
    }
    
// Function to delete a customer account
public void delete_customer(){
        int temp_acc_no;
    System.out.print("Enter your account no: ");
    temp_acc_no=sc.nextInt();
    sc.nextLine();
 
    Account_Node temp_node=head;
   
    boolean account_found=false;
    if(temp_node==null){
        System.out.println("Customer list is empty .....no account is present.");
        return;
    }
    if(head.account_no==temp_acc_no) {
    	head=head.next;
    	temp_node.next=null;
    }
    else {
    	Account_Node del_node=head;
        Account_Node prev_node=null;
    while(del_node!=null){
    	
        if(del_node.account_no==temp_acc_no){
        	
        	
            account_found=true;
            prev_node.next=del_node.next;
            del_node.next=null;
            System.out.println("Your account is deleted successfully.....");
            break;

        }else {
        	prev_node=del_node;
            del_node=del_node.next;
        }

    }
      if(account_found==false){
          System.out.println("Your account is not in our bank....");
      }
    }
}

// Function to deposit money in an account
public void deposit() {
        int accno;
        System.out.print("Enter your account no: ");
        accno=sc.nextInt();
        Account_Node temp=head;
        if(head==null) {
            System.out.println("List is empty");
            return;
        }
        while(temp!=null) {
            if(temp.account_no==accno) {
                int deposit_amount;
                System.out.print("Enter the amount you want to deposit: ");
                deposit_amount=sc.nextInt();

                temp.balance=temp.balance+deposit_amount;

                System.out.println("Your balance is updated.... Your current balance is: "+temp.balance);
                break;
            }else{
                temp=temp.next;
            }
        }


    }

// Function to withdraw money from an account
public void withdraw() {
        int accno;
        System.out.print("Enter your account no: ");
        accno=sc.nextInt();
        Account_Node temp=head;
        if(head==null) {
            System.out.println("List is empty");
            return;
        }
       if(temp!=null) {
            if(temp.account_no==accno) {
                int withdraw_amount;
                System.out.print("Enter the amount you want to withdraw: ");
                withdraw_amount=sc.nextInt();

                temp.balance=temp.balance-withdraw_amount;

                System.out.println("Your money is withdrawn");
                System.out.println("CUrrent balance is: "+temp.balance);

            }
        }


    }

}

// Main Class
public class Bank_Management_System {
	 public static void main(String[] args) {
	        // TODO Auto-generated method stub
	        bank b=new bank();
	        Scanner sc=new Scanner(System.in);
	        char option;
	        
	        // Using do-while loop to ask whether the user wants to continue? 
	        do {
	            System.out.println("1) ADD COSTUMER ");
	            System.out.println("2) DISPLAY COSTUMER");
	            System.out.println("3) DEPOSIT MONEY TO ACCOUNT");
	            System.out.println("4) WITHDRAW MONEY FROM ACCOUNT");
	            System.out.println("5) DELETE ACCOUNT");
	            System.out.print("==>ENTER YOUR CHOICE: ");
	            int operation = sc.nextInt();
	            sc.nextLine();
	            
	            // Using switch case for operating on menu
	            switch (operation) {
	                case 1:
	                    System.out.print("Enter number of customers you want to add: ");
	                    int no = sc.nextInt();
	                    for (int i = 0; i < no; i++) {
	                        b.insert();
	                    }
	                    break;

	                case 2:
	                    System.out.println("List of all customers.....");
	                    b.display();
	                    break;
	                case 3:

	                    b.deposit();
	                    break;
	                    
	                case 4:

	                    b.withdraw();
	                    break;    
	                case 5:
	                    b.delete_customer();
	                    break;
	        		default:System.out.println("Enter Valid Number!");

	            }

	            System.out.println("Would you like to continue? If yes, press Y ");
	            
	            option=sc.next().charAt(0);
	            sc.nextLine();
	        }while (option=='Y');

	    }
}




//*********** OUTPUT *********** //

//1) ADD COSTUMER 
//2) DISPLAY COSTUMER
//3) DEPOSIT MONEY TO ACCOUNT
//4) WITHDRAW MONEY FROM ACCOUNT
//5) DELETE ACCOUNT
//==>ENTER YOUR CHOICE: 1
//Enter number of customers you want to add: 2
//Enter your account no: 13
//Enter your name: Samiksha
//Enter your address: Manhattan
//Enter your balance: 1000000000
//Enter your account no: 15
//Enter your name: Rajshree
//Enter your address: California
//Enter your balance: 100000000
//Would you like to continue? If yes, press Y 
//Y
//1) ADD COSTUMER 
//2) DISPLAY COSTUMER
//3) DEPOSIT MONEY TO ACCOUNT
//4) WITHDRAW MONEY FROM ACCOUNT
//5) DELETE ACCOUNT
//==>ENTER YOUR CHOICE: 2
//List of all customers.....
//Account No: 13
//Name: Samiksha
//Address: Manhattan
//Balance = 1000000000
//Account No: 15
//Name: Rajshree
//Address: California
//Balance = 100000000
//Would you like to continue? If yes, press Y 
//Y
//1) ADD COSTUMER 
//2) DISPLAY COSTUMER
//3) DEPOSIT MONEY TO ACCOUNT
//4) WITHDRAW MONEY FROM ACCOUNT
//5) DELETE ACCOUNT
//==>ENTER YOUR CHOICE: 3
//Enter your account no: 15
//Enter the amount you want to deposit: 100000000
//Your balance is updated.... Your current balance is: 200000000
//Would you like to continue? If yes, press Y 
//Y
//1) ADD COSTUMER 
//2) DISPLAY COSTUMER
//3) DEPOSIT MONEY TO ACCOUNT
//4) WITHDRAW MONEY FROM ACCOUNT
//5) DELETE ACCOUNT
//==>ENTER YOUR CHOICE: 4
//Enter your account no: 13
//Enter the amount you want to withdraw: 10000000
//Your money is withdrawn
//CUrrent balance is: 990000000
//Would you like to continue? If yes, press Y 
//Y
//1) ADD COSTUMER 
//2) DISPLAY COSTUMER
//3) DEPOSIT MONEY TO ACCOUNT
//4) WITHDRAW MONEY FROM ACCOUNT
//5) DELETE ACCOUNT
//==>ENTER YOUR CHOICE: 5
//Enter your account no: 13
//Would you like to continue? If yes, press Y 
//Y
//1) ADD COSTUMER 
//2) DISPLAY COSTUMER
//3) DEPOSIT MONEY TO ACCOUNT
//4) WITHDRAW MONEY FROM ACCOUNT
//5) DELETE ACCOUNT
//==>ENTER YOUR CHOICE: 2
//List of all customers.....
//Account No: 15
//Name: Rajshree
//Address: California
//Balance = 200000000
//Would you like to continue? If yes, press Y 