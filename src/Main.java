import business.abstracts.UserService;
import business.concretes.UserManager;
import core.CheckGoogleAccountAdaptor;
import core.VerifyEmailAdaptor;
import dataAccess.concretes.HibernateUserDao;
import emailVerification.VerifyEmail;
import entities.concretes.User;

public class Main {

	public static void main(String[] args) {

		UserService userService = new UserManager(new HibernateUserDao(), new VerifyEmailAdaptor(new VerifyEmail()),new CheckGoogleAccountAdaptor());
		
		userService.logIn(new User("ahmet", "temel", "google", "123456"));
	}

}
