package p3_7;



public class Transaction extends Thread {
	private Account account = new Account(1000);
	private int withdraw;

	public Transaction(Account account, int withdraw) {
		this.account = account;
		this.withdraw = withdraw;
	}

	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		synchronized (account) {
			int total = account.get();
			if(total>= withdraw) {
				account.set(total - withdraw);
			}
		}
	}

}
