package core;

import emailVerification.VerifyEmail;

public class VerifyEmailAdaptor implements VerificationService{
	
	private VerifyEmail verifyEmail;
	
	public VerifyEmailAdaptor(VerifyEmail verifyEmail) {
		this.verifyEmail=verifyEmail;
	}
	
	public void sendEmail() {
		verifyEmail.sendEmail();
	}
	
	public boolean emailVerified() {
		
		return verifyEmail.emailVerified();
	}

}
