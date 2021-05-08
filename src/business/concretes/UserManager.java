package business.concretes;

import java.util.ArrayList;
import java.util.List;

import business.abstracts.UserService;
import business.utils.EmailValidator;
import core.CheckAccountService;
import core.VerificationService;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class UserManager implements UserService{
	
	private UserDao userDao;
	private VerificationService verificationService;
	private CheckAccountService checkAccountService;
	
	public UserManager(UserDao userDao,VerificationService verificationService,CheckAccountService checkAccountService) {
		this.userDao = userDao;
		this.verificationService = verificationService;
		this.checkAccountService = checkAccountService;
	}

	@Override
	public void signIn(User user) {

		if(user.getPassword().length()<6) {
			System.out.println("Password needs to be at least 6 characters");
			return;
		}else if(!EmailValidator.validate(user.getEmail())) {
			System.out.println("Invalid Email format");
			return;
		}else if(user.getFirstName().length()<2 || user.getLasttName().length()<2) {
			System.out.println("Firstname and lastname must be longer than 2 characters");
			return;
		}
		for (User users : getAll()) {
			if(users.getEmail()==user.getEmail()) {
				System.out.println("This email is being used by another user");
				return;
			}
		}
		this.userDao.signIn(user);
		this.verificationService.sendEmail();
		this.verificationService.emailVerified();
	}

	@Override
	public void logIn(User user) {

		if(user.getEmail()==null) {
			System.out.println("Email is mandatory");
			return;
		}else if(user.getPassword()==null) {
			System.out.println("Password is mandatory");
			return;
		}
		for (User users : getAll()) {
			if(users.getEmail()=="google"){
				checkAccountService.checkAccount(user.getEmail());
				return;
			}
			else if(users.getEmail()==user.getEmail()&& users.getPassword()==user.getPassword()) {
				System.out.println("Succesfully logged on");
				return;
			}
			else {
				System.out.println("Check email or password ");
			}
		}
	}

	@Override
	public List<User> getAll() {
		List<User> users = new ArrayList<User>();
		User user = new User("ahmet","temel","google","123456");
		users.add(user);
		return users;
	}

	
	

}
