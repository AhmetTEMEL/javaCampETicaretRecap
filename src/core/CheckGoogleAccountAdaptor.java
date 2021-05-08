package core;

public class CheckGoogleAccountAdaptor implements CheckAccountService{

	@Override
	public void checkAccount(String account) {
		
		if(account=="google") {
			System.out.println("Logged on with google account" + account);
		}

	}

}
