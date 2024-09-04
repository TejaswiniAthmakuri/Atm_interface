
import java.util.Scanner;

class BankAccount
{
    private double balance;
    public BankAccount(double initialBalance)
    {
        this.balance=initialBalance;
        
    }
    public double getBalance()
    {
        return balance;
    }
    public void deposit(double amount){
        if(amount>=0)
        {
            balance+=amount;
            System.out.println("Deposit Successful.");
            System.out.println("Current balance: " +balance);
        }
        else
        {
            System.out.println("Invalid deposit amount.");
        }
    }
    public void withdraw(double amount){
        if(amount>0 && amount<=balance)
        {
            balance-=amount;
            System.out.println("withdrawl  Successful. ");
            System.out.println("Current balance: " + balance);
        }
        else
        {
            System.out.println("Invalid withdrawl amount or insufficient balance.");
        }
    }
}

class Atm
{
    private BankAccount bankAccount;
    public Atm(BankAccount bankAccount){
        this.bankAccount=bankAccount;
    }
    
    public void display()
    {
        System.out.println("ATM MENU:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3.Withdraw");
        System.out.println("4. Exit");
    }
    
    public void performTransaction(int choice, Scanner scanner)
    {
        switch(choice)
        {
            case 1:
                System.out.println("Current balance: " + bankAccount.getBalance());
                break;
            case 2:
                System.out.print("Enter the deposit amount: ");
                double depositAmount=scanner.nextDouble();
                bankAccount.deposit(depositAmount);
                break;
            case 3:
                System.out.print("Enter the withdraw amount: ");
                double withdrawlAmount=scanner.nextDouble();
                bankAccount.withdraw(withdrawlAmount);
                break;
            case 4:
                System.out.println("Thank you! visit Again.");
                scanner.close();
                System.exit(0);
            default:
            System.out.println("Inavalid choice. Please select a valid option.");
        }
    }
    
}


public class Atm_interface
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter initial account balance: ");
		double initialBalance=scanner.nextDouble();
		BankAccount  bankAccount=new BankAccount(initialBalance);
		
		Atm atm =new Atm(bankAccount);
		
		while(true)
		{
		    atm.display();
		    System.out.print("Select an option:");
		    int choice =scanner.nextInt();
		    atm.performTransaction(choice, scanner);
		}
	}
}