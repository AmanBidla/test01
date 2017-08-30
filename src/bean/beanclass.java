package bean;

public class beanclass {

	private int accountnumber;
	private String firstname;
	private String lastname;
	private int balance;
	private int withdraw;
	//private int deposit;
	
	public beanclass(){
		
	}

	public beanclass(int accountnumber, int withdraw){
		this.accountnumber =accountnumber;
		this.withdraw = withdraw;
	}
	
	public beanclass(int accountnumber, String firstname, String lastname, int balance){
		this.accountnumber = accountnumber;
		this.firstname = firstname;
		this.lastname = lastname;
		this.balance = balance;
	}
	
	public void setwithdraw(int withdraw){
		this.withdraw = withdraw;
	}
	
	public int getwithdraw(){
		return withdraw;
	}
	
	public void setaccountnumber(int accountnumber){
		this.accountnumber = accountnumber;
	}
	
	public int getaccountnumber(){
		return accountnumber;
	}
	
	public void setfirstname(String firstname){
		this.firstname = firstname;
	}
	
	public String getfirstname(){
		return firstname;
	}
	
	public void setlastname(String lastname){
		this.lastname = lastname;
	}
	
	public String getlastname(){
		return lastname;
	}
	
	public void setbalance(int balance){
		this.balance = balance;
	}
	
	public int getbalance(){
		return balance;
	}
	
}
