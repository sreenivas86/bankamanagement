package bank.user;

public interface Transactions {
	public void withDraw(int ammount);
	public void deposit(int ammout);
	public void checkBalance();
	public void sendMoney();

}
